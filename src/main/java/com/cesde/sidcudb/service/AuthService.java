package com.cesde.sidcudb.service;

import com.cesde.sidcudb.dto.request.LoginRequestDTO;
import com.cesde.sidcudb.dto.request.RegistroRequestDTO;
import com.cesde.sidcudb.dto.response.LoginResponseDTO;
import com.cesde.sidcudb.exception.ReglaDeNegocioException;
import com.cesde.sidcudb.model.entity.Administrador;
import com.cesde.sidcudb.model.entity.Estudiante;
import com.cesde.sidcudb.repository.AdministradorRepository;
import com.cesde.sidcudb.repository.EstudianteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Locale;

@Service
public class AuthService {

    private final EstudianteRepository estudianteRepository;
    private final AdministradorRepository administradorRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(EstudianteRepository estudianteRepository,
                       AdministradorRepository administradorRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {
        this.estudianteRepository = estudianteRepository;
        this.administradorRepository = administradorRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Transactional
    public LoginResponseDTO registrar(RegistroRequestDTO request) {
        if (!request.contrasena().equals(request.confirmarContrasena())) {
            throw new ReglaDeNegocioException("Las contraseñas no coinciden");
        }

        String documento = request.documento().trim();
        String correo = normalizarCorreo(request.correo());

        if (estudianteRepository.existsByDocumento(documento)) {
            throw new ReglaDeNegocioException("Ya existe un estudiante con ese documento");
        }

        if (estudianteRepository.existsByCorreo(correo) || administradorRepository.existsByCorreo(correo)) {
            throw new ReglaDeNegocioException("Ya existe una cuenta con ese correo");
        }

        Estudiante estudiante = new Estudiante();
        estudiante.setDocumento(documento);
        estudiante.setNombre(request.nombre().trim());
        estudiante.setApellido(request.apellido().trim());
        estudiante.setCiudad(request.ciudad().trim());
        estudiante.setCorreo(correo);
        estudiante.setContrasena(passwordEncoder.encode(request.contrasena()));

        Estudiante guardado = estudianteRepository.save(estudiante);

        return crearRespuesta(
                guardado.getId(),
                guardado.getNombre() + " " + guardado.getApellido(),
                guardado.getCorreo(),
                "ESTUDIANTE"
        );
    }

    @Transactional(readOnly = true)
    public LoginResponseDTO login(LoginRequestDTO request) {
        String correo = normalizarCorreo(request.correo());

        Administrador administrador = administradorRepository.findByCorreo(correo).orElse(null);
        if (administrador != null && passwordEncoder.matches(request.contrasena(), administrador.getContrasena())) {
            return crearRespuesta(
                    administrador.getId(),
                    administrador.getNombre(),
                    administrador.getCorreo(),
                    "ADMINISTRADOR"
            );
        }

        Estudiante estudiante = estudianteRepository.findByCorreo(correo).orElse(null);
        if (estudiante != null && passwordEncoder.matches(request.contrasena(), estudiante.getContrasena())) {
            return crearRespuesta(
                    estudiante.getId(),
                    estudiante.getNombre() + " " + estudiante.getApellido(),
                    estudiante.getCorreo(),
                    "ESTUDIANTE"
            );
        }

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Correo o contraseña incorrectos");
    }

    private LoginResponseDTO crearRespuesta(Long id, String nombre, String correo, String tipo) {
        return new LoginResponseDTO(
                jwtService.generarToken(correo, tipo),
                "Bearer",
                id,
                nombre,
                correo
        );
    }

    private String normalizarCorreo(String correo) {
        return correo.trim().toLowerCase(Locale.ROOT);
    }
}
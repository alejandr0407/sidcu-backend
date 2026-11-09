
package com.cesde.sidcudb.service;

import com.cesde.sidcudb.dto.request.RegistroRequestDTO;
import com.cesde.sidcudb.dto.request.LoginRequestDTO;
import com.cesde.sidcudb.dto.response.EstudianteResponseDTO;
import com.cesde.sidcudb.dto.response.LoginResponseDTO;
import com.cesde.sidcudb.model.entity.Estudiante;
import com.cesde.sidcudb.model.entity.Administrador;
import com.cesde.sidcudb.repository.EstudianteRepository;
import com.cesde.sidcudb.repository.AdministradorRepository;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {

    private final EstudianteRepository estudianteRepository;
    private final AdministradorRepository administradorRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
            EstudianteRepository estudianteRepository,
            AdministradorRepository administradorRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.estudianteRepository = estudianteRepository;
        this.administradorRepository = administradorRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    // REGISTRO DE ESTUDIANTES
    public EstudianteResponseDTO registrar(
            RegistroRequestDTO datos
    ) {

        if (!datos.contrasena().equals(datos.confirmarContrasena())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Las contraseñas no coinciden"
            );
        }

        if (estudianteRepository.existsByCorreo(datos.correo())
                || administradorRepository.existsByCorreo(datos.correo())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "El correo ya está registrado"
            );
        }

        if (estudianteRepository.existsByDocumento(datos.documento())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "El documento ya está registrado"
            );
        }

        Estudiante estudiante = new Estudiante();

        estudiante.setDocumento(datos.documento());
        estudiante.setNombre(datos.nombre());
        estudiante.setApellido(datos.apellido());
        estudiante.setCiudad(datos.ciudad());
        estudiante.setCorreo(datos.correo());
        estudiante.setContrasena(
                passwordEncoder.encode(datos.contrasena())
        );

        Estudiante guardado =
                estudianteRepository.save(estudiante);

        return new EstudianteResponseDTO(
                guardado.getId(),
                guardado.getDocumento(),
                guardado.getNombre(),
                guardado.getCiudad()
        );
    }

    // INICIO DE SESIÓN
    public LoginResponseDTO iniciarSesion(
            LoginRequestDTO datos
    ) {

        String correo = datos.correo().trim().toLowerCase();

        // Primero buscamos si es administrador
        Administrador administrador =
                administradorRepository.findByCorreo(correo)
                        .orElse(null);

        if (administrador != null) {

            if (!Boolean.TRUE.equals(administrador.getEstadoActivo())
                    || !passwordEncoder.matches(
                            datos.contrasena(),
                            administrador.getContrasena())) {

                throw new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED,
                        "Correo o contraseña incorrectos"
                );
            }

            String token = jwtService.generarToken(
                    administrador.getId(),
                    administrador.getCorreo(),
                    administrador.getNombre(),
                    "ADMIN"
            );

            return new LoginResponseDTO(
                    token,
                    "ADMIN",
                    administrador.getId(),
                    administrador.getNombre(),
                    administrador.getCorreo()
            );
        }

        // Si no es administrador, buscamos estudiante
        Estudiante estudiante =
                estudianteRepository.findByCorreo(correo)
                        .orElse(null);

        if (estudiante == null
                || !Boolean.TRUE.equals(estudiante.getEstadoActivo())
                || !passwordEncoder.matches(
                        datos.contrasena(),
                        estudiante.getContrasena())) {

            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Correo o contraseña incorrectos"
            );
        }

        String token = jwtService.generarToken(
                estudiante.getId(),
                estudiante.getCorreo(),
                estudiante.getNombre(),
                "ESTUDIANTE"
        );

        return new LoginResponseDTO(
                token,
                "ESTUDIANTE",
                estudiante.getId(),
                estudiante.getNombre(),
                estudiante.getCorreo()
        );
    }
}

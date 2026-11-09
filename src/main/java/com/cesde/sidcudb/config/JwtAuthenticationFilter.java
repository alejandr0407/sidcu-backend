
package com.cesde.sidcudb.config;

import com.cesde.sidcudb.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtAuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String encabezado = request.getHeader("Authorization");

        // Si no hay token, continúa la petición.
        if (encabezado == null || !encabezado.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = encabezado.substring(7);

        try {
            Claims claims = jwtService.validarToken(token);

            String correo = claims.getSubject();
            String tipo = claims.get("tipo", String.class);

            if (correo != null && tipo != null
                    && SecurityContextHolder.getContext().getAuthentication() == null) {

                var autoridad = new SimpleGrantedAuthority(
                        "ROLE_" + tipo.toUpperCase()
                );

                var autenticacion =
                        new UsernamePasswordAuthenticationToken(
                                correo,
                                null,
                                List.of(autoridad)
                        );

                SecurityContextHolder.getContext()
                        .setAuthentication(autenticacion);
            }

        } catch (JwtException | IllegalArgumentException e) {
            SecurityContextHolder.clearContext();
        }

        filterChain.doFilter(request, response);
    }
}

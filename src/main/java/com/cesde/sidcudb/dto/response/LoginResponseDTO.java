package com.cesde.sidcudb.dto.response;

/** Respuesta básica de registro e inicio de sesión, sin token. */
public record LoginResponseDTO(
        Long id,
        String nombre,
        String correo,
        String tipo
) {
}

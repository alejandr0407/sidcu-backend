
package com.cesde.sidcudb.dto.response;

public record LoginResponseDTO(
        String token,
        String tipo,
        Long id,
        String nombre,
        String correo
) {
}

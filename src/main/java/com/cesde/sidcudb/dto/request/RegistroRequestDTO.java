
package com.cesde.sidcudb.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegistroRequestDTO(

        @NotBlank(message = "El documento es obligatorio")
        @Size(max = 20)
        String documento,

        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 100)
        String nombre,

        @NotBlank(message = "El apellido es obligatorio")
        @Size(max = 100)
        String apellido,

        @NotBlank(message = "La ciudad es obligatoria")
        @Size(max = 50)
        String ciudad,

        @NotBlank(message = "El correo es obligatorio")
        @Email(message = "El correo no es válido")
        @Size(max = 100)
        String correo,

        @NotBlank(message = "La contraseña es obligatoria")
        @Size(min = 8, max = 100,
                message = "La contraseña debe tener mínimo 8 caracteres")
        String contrasena,

        @NotBlank(message = "Debes confirmar la contraseña")
        String confirmarContrasena

) {
}

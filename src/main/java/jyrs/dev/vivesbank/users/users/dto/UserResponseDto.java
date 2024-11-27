package jyrs.dev.vivesbank.users.users.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto{
        private String guuid;
        @NotBlank(message = "El nombre de usuario no puede estar vacío")
        String username;
        @NotBlank(message = "La ruta de la imagen no puede estar vacía")
        String fotoPerfil;
        Boolean isDeleted;
}


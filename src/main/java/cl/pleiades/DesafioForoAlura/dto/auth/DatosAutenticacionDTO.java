package cl.pleiades.DesafioForoAlura.dto.auth;

import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionDTO(
        @NotBlank String email,
        @NotBlank String password
) {
}
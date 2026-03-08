package cl.pleiades.DesafioForoAlura.dto.topico;

import cl.pleiades.DesafioForoAlura.model.EstadoTopico;
import jakarta.validation.constraints.NotNull;

public record DatosActualizacionTopico(
        Long id,
        String titulo,
        String mensaje,
        EstadoTopico estado
) {
}
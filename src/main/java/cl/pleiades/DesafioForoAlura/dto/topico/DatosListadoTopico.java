package cl.pleiades.DesafioForoAlura.dto.topico;

import cl.pleiades.DesafioForoAlura.model.Topico;
import java.time.LocalDateTime;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String estado,
        String autorNombre,
        String cursoNombre
) {
    public DatosListadoTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getEstado().name(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre()
        );
    }
}
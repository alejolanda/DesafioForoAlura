package cl.pleiades.DesafioForoAlura.dto.topico;

import cl.pleiades.DesafioForoAlura.model.Topico;
import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String estado,
        String autorNombre,
        String autorEmail,
        String cursoNombre,
        String cursoCategoria
) {
    public DatosDetalleTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getEstado().name(),
                topico.getAutor().getNombre(),
                topico.getAutor().getEmail(),
                topico.getCurso().getNombre(),
                topico.getCurso().getCategoria()
        );
    }
}
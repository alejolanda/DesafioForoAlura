package cl.pleiades.DesafioForoAlura.service;

import cl.pleiades.DesafioForoAlura.dto.topico.DatosActualizacionTopico;
import cl.pleiades.DesafioForoAlura.dto.topico.DatosDetalleTopico;
import cl.pleiades.DesafioForoAlura.dto.topico.DatosListadoTopico;
import cl.pleiades.DesafioForoAlura.dto.topico.DatosRegistroTopicos;
import cl.pleiades.DesafioForoAlura.model.Curso;
import cl.pleiades.DesafioForoAlura.model.Topico;
import cl.pleiades.DesafioForoAlura.model.Usuario;
import cl.pleiades.DesafioForoAlura.repository.CursoRepository;
import cl.pleiades.DesafioForoAlura.repository.TopicoRepository;
import cl.pleiades.DesafioForoAlura.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    public DatosListadoTopico crearTopico(DatosRegistroTopicos datos) {
        Optional<Topico> topicoExistente = topicoRepository.findByTituloAndMensaje(
                datos.titulo(),
                datos.mensaje()
        );

        if (topicoExistente.isPresent()) {
            throw new RuntimeException("Ya existe un tópico con el mismo título y mensaje");
        }

        Usuario autor = usuarioRepository.findById(datos.autorId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        Curso curso = cursoRepository.findById(datos.cursoId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Topico topico = new Topico(datos.titulo(), datos.mensaje(), autor, curso);
        topicoRepository.save(topico);

        return new DatosListadoTopico(topico);
    }

    public List<DatosListadoTopico> listarTopicos() {
        return topicoRepository.findAll().stream()
                .map(DatosListadoTopico::new)
                .toList();
    }

    public DatosDetalleTopico obtenerDetalleTopico(Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));

        return new DatosDetalleTopico(topico);
    }

    @Transactional
    public DatosListadoTopico actualizarTopico(DatosActualizacionTopico datos) {
        Topico topico = topicoRepository.findById(datos.id())
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));

        topico = topicoRepository.save(topico);

        return new DatosListadoTopico(topico);
    }

    @Transactional
    public void eliminarTopico(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new RuntimeException("Tópico no encontrado");
        }
        topicoRepository.deleteById(id);
    }
}
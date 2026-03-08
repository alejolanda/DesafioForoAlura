package cl.pleiades.DesafioForoAlura.controller;

import cl.pleiades.DesafioForoAlura.dto.topico.*;
import cl.pleiades.DesafioForoAlura.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<DatosListadoTopico> crearTopico(@RequestBody @Valid DatosRegistroTopicos datos, UriComponentsBuilder uriBuilder) {
        DatosListadoTopico topicoCreado = topicoService.crearTopico(datos);
        URI url = uriBuilder.path("/topicos/{id}").buildAndExpand(topicoCreado.id()).toUri();
        return ResponseEntity.created(url).body(topicoCreado); // 201
    }

    @GetMapping
    public ResponseEntity<List<DatosListadoTopico>> listarTopicos() {
        return ResponseEntity.ok(topicoService.listarTopicos()); // 200
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> obtenerDetalleTopico(@PathVariable Long id) {
        return ResponseEntity.ok(topicoService.obtenerDetalleTopico(id)); // 200
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosListadoTopico> actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizacionTopico datos) {
        DatosActualizacionTopico datosConId = new DatosActualizacionTopico(id, datos.titulo(), datos.mensaje(), datos.estado());
        return ResponseEntity.ok(topicoService.actualizarTopico(datosConId)); // 200
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build(); // 204
    }
}
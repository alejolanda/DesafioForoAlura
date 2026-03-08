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
        return ResponseEntity.created(url).body(topicoCreado);
    }

    @GetMapping
    public List<DatosListadoTopico> listarTopicos() {
        return topicoService.listarTopicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> obtenerDetalleTopico(@PathVariable Long id) {
        DatosDetalleTopico topico = topicoService.obtenerDetalleTopico(id);
        return ResponseEntity.ok(topico);
    }

    @PutMapping
    public ResponseEntity<DatosListadoTopico> actualizarTopico(@RequestBody @Valid DatosActualizacionTopico datos) {
        DatosListadoTopico topicoActualizado = topicoService.actualizarTopico(datos);
        return ResponseEntity.ok(topicoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }
}
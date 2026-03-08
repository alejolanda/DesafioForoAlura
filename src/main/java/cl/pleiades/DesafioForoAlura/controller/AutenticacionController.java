package cl.pleiades.DesafioForoAlura.controller;

import cl.pleiades.DesafioForoAlura.dto.auth.DatosAutenticacionDTO;
import cl.pleiades.DesafioForoAlura.dto.auth.DatosTokenDTO;
import cl.pleiades.DesafioForoAlura.service.AutenticacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacionController {

    @Autowired
    private AutenticacionService autenticacionService;

    @PostMapping("/login")
    public ResponseEntity<DatosTokenDTO> autenticarUsuario(@RequestBody @Valid DatosAutenticacionDTO datos) {
        String token = autenticacionService.autenticarUsuario(datos);
        return ResponseEntity.ok(new DatosTokenDTO(token));
    }
}
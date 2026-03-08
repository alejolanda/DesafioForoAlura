package cl.pleiades.DesafioForoAlura.service;

import cl.pleiades.DesafioForoAlura.dto.auth.DatosAutenticacionDTO;
import cl.pleiades.DesafioForoAlura.model.Usuario;
import cl.pleiades.DesafioForoAlura.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService implements UserDetailsService {

    @Autowired
    @Lazy  // ← AGREGAR ESTA ANOTACIÓN
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con email: " + username));
    }

    public String autenticarUsuario(DatosAutenticacionDTO datos) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(
                datos.email(),
                datos.password()
        );

        var usuarioAutenticado = authenticationManager.authenticate(authenticationToken);

        return tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
    }
}
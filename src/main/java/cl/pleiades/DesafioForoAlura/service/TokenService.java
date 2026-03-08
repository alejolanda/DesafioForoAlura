package cl.pleiades.DesafioForoAlura.service;

import cl.pleiades.DesafioForoAlura.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String jwtSecret;

    public String generarToken(Usuario usuario) {
        try {
            SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());

            return Jwts.builder()
                    .issuer("ForoHub")
                    .subject(usuario.getEmail())
                    .expiration(new Date(System.currentTimeMillis() + 3600000L))
                    .signWith(key)
                    .compact();
        } catch (Exception exception) {
            throw new RuntimeException("Error al generar el token JWT", exception);
        }
    }

    public String obtenerSubject(String token) {
        try {
            SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());

            Claims claims = Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            return claims.getSubject();
        } catch (Exception exception) {
            throw new RuntimeException("Token inválido o expirado", exception);
        }
    }
}
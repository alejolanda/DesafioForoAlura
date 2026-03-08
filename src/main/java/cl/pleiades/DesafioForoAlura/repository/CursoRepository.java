package cl.pleiades.DesafioForoAlura.repository;

import cl.pleiades.DesafioForoAlura.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
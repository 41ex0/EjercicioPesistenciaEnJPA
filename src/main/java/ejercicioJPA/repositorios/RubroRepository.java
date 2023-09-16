package ejercicioJPA.repositorios;

import ejercicioJPA.entidades.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RubroRepository extends JpaRepository<Rubro, Long> {
}

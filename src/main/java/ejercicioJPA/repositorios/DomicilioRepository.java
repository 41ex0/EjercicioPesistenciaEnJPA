package ejercicioJPA.repositorios;

import ejercicioJPA.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
}

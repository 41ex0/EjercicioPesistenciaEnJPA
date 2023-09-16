package ejercicioJPA.repositorios;

import ejercicioJPA.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}

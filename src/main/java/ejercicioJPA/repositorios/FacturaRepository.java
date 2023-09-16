package ejercicioJPA.repositorios;

import ejercicioJPA.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura,Long> {
}

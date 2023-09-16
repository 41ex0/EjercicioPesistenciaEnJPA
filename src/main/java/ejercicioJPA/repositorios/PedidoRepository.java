package ejercicioJPA.repositorios;

import ejercicioJPA.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

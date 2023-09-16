package ejercicioJPA.repositorios;

import ejercicioJPA.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Long> {
}

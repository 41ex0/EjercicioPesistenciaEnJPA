package ejercicioJPA.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetallePedido extends BaseEntidad{

    private int cantidad;
    private double subtotal;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn (name = "producto_id")
    private Producto producto;
}

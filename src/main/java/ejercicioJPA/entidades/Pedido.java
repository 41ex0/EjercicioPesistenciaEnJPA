package ejercicioJPA.entidades;

import ejercicioJPA.enumeraciones.Estado;
import ejercicioJPA.enumeraciones.TipoEnvio;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido extends BaseEntidad{

    private Estado estado;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private TipoEnvio tipoEnvio;
    private double total;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    @Builder.Default
    private List<DetallePedido> detallesPedido = new ArrayList<>();

    public void agregarDetallePedido(DetallePedido detalle){

        detallesPedido.add(detalle);
    }

    public void mostrarDetallesPedidos(){

        System.out.println("mostrarDetallesPedido: DetallesPedidos de Pedido ID " + this.getId());
        for (DetallePedido detalle : detallesPedido) {
            System.out.println ("   ID DetallePedido: " + detalle.getId() +
                                ", cantidad: " + detalle.getCantidad() +
                                ", subtotal: " + detalle.getSubtotal()
                                );
        }
    }

}

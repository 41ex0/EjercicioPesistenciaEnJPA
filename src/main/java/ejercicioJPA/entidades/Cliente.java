package ejercicioJPA.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente extends BaseEntidad {

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id") //para que en el lado muchos el FK sea cliente_id
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    public void agregarPedido(Pedido pedi){

        pedidos.add(pedi);
    }

    public void mostrarPedidos(){

        System.out.println("MostrarPedidos: Pedido de " + nombre + ":");
        for (Pedido pedido : pedidos) {
            System.out.println ("ID Pedido " + pedido.getId() +
                                ", Estado: " + pedido.getEstado() +
                                ", fecha: " + pedido.getFecha() +
                                ", tipoEnvio: " + pedido.getTipoEnvio() +
                                ", total: " + pedido.getTotal()
                                );
            pedido.mostrarDetallesPedidos();
        }
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    @Builder.Default
    private List<Domicilio> domicilios = new ArrayList<>();

    public void agregarDomicilio(Domicilio domi){

        domicilios.add(domi);
    }

    public void mostrarDomicilios(){

        System.out.println("MostrarDomicilios: Domicilio de " + nombre + ":");
        for (Domicilio domicilio : domicilios) {
            System.out.println ("ID Domicilio " + domicilio.getId() +
                                ", Calle: " + domicilio.getCalle() +
                                ", numero: " + domicilio.getNumero() +
                                ", tipoEnvio: " + domicilio.getLocalidad()
                                );
        }
    }

}

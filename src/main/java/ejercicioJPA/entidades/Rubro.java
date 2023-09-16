package ejercicioJPA.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rubro extends BaseEntidad{

    private String denominacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "rubro_id")
    @Builder.Default
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto prod){

        productos.add(prod);
    }

    public void mostrarProducto(){

        System.out.println("mostrarProducto: Producto de Rubro " + denominacion);
        for (Producto producto : productos) {
            System.out.println("ID Producto: " + producto.getId() +
                                ", tipo: " + producto.getTipo() +
                                ", tiempoEstimadoCocina: " + producto.getTiempoEstimadoCocina() +
                                ", denominacion: " + producto.getDenominacion() +
                                ", precioVenta: " + producto.getPrecioVenta() +
                                ", precioCompra: " + producto.getPrecioCompra() +
                                ", stockActual: " + producto.getStockActual() +
                                ", stockMinimo: " + producto.getStockMinimo() +
                                ", unidadMedida: " + producto.getUnidadMedida() +
                                ", receta: " + producto.getReceta()
                                );
        }
    }

}

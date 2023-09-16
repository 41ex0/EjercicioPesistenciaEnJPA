package ejercicioJPA.entidades;

import ejercicioJPA.enumeraciones.Tipo;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto extends BaseEntidad {

    private Tipo tipo;
    private int tiempoEstimadoCocina;
    private String denominacion;
    private double precioVenta;
    private double precioCompra;
    private int stockActual;
    private int stockMinimo;
    private String unidadMedida;
    private String receta;
}

package ejercicioJPA.entidades;

import ejercicioJPA.enumeraciones.FormaPago;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura extends BaseEntidad{

    private int numero;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private double descuento;
    private FormaPago formaPago;
    private int total;
}

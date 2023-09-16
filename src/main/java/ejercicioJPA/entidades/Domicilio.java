package ejercicioJPA.entidades;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Domicilio extends BaseEntidad{

    private String calle;
    private String numero;
    private String localidad;
}

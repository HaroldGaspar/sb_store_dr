package pe.isil.modelEn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
@Embeddable
public class KeyCartDetail implements Serializable {

    private Integer CartId;
    private Integer ProductId;

}

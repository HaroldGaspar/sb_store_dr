package pe.isil.modelEn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Table(name = "cart_detail")
@Entity
public class CartDetail implements Serializable {

    @EmbeddedId
    private KeyCartDetail id;

    private Integer amount;

    //////////////////////////////////////////////////
        @ManyToOne
        @MapsId("cartId")
        @JoinColumn(name = "cartId")
        private Cart cart;

        @ManyToOne
        @MapsId("productId")
        @JoinColumn(name = "productId")
        private Product product;
    //////////////////////////////////////////////////

}

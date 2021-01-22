package pe.isil.modelEn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Table(name = "cart")
@Entity
public class Cart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;

    @Column(precision = 10, scale = 2)
    private Double subtotal;

    //////////////////////////////////////////////////

        //[FK]
        @OneToOne(fetch = FetchType.LAZY)//jalar el carrito de un cliente
        @JoinColumn(name = "clientId")
        private Client client;

        @OneToOne(mappedBy = "cart")
        private  Bill bill;


        @OneToMany(mappedBy = "cart")
        private List<CartDetail> ListCartDetail;

    //////////////////////////////////////////////////

    public Cart(Integer id, Client client) {
        this.cartId = id;
        this.client = client;
    }
}

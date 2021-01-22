package pe.isil.modelEn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Table(name = "Factura")
@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10)
    private Integer billId;
    private String paymentMeans;
    private Double amount;
    private LocalDate purchaseDate;
    private LocalDate deliveryDate;
    //////////////////////////////////////////////////
        //[FK]
        @ManyToOne(fetch = FetchType.LAZY)//jalar las facturas de un cliente
        @JoinColumn(name = "clientId")
        private Client client;

        //[FK]
        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "cartId")
        private Cart cart;

//    public Factura(Integer id, String medio, Integer monto, LocalDate compra, LocalDate entrega, Cliente cliente, Carrito carrito) {
//        this.idFactura = id;
//        this.medioPago = medio;
//        this.monto = monto;
//        this.fechaCompra = compra;
//        this.fechaEntrega = entrega;
//        this.cliente = cliente;
//        this.carrito = carrito;
//    }
    //////////////////////////////////////////////////
}

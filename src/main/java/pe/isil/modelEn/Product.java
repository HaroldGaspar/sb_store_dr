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

@Table(name = "product")
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String name;
    private String description;
    private Integer stock;
    @Column(precision = 10, scale = 2)
    private Double price;
    private Integer weightGrams;
    private String imgUrl;


    //////////////////////////////////////////////////
    //@OneToOne(cascade = CascadeType.ALL)//auto persis
        //[FK]
        @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)//jala los productos de una cat
        @JoinColumn(name = "categoryId")
        private ProductCategory productCategory;

        @OneToMany(mappedBy = "product")//err=(mappedBy = "carrito")
        private List<CartDetail> cartDetailList;


    //////////////////////////////////////////////////


    public Product(String name, String description, Integer stock, Double price, Integer weightGrams, String imgUrl) {
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.weightGrams = weightGrams;
        this.imgUrl = imgUrl;
    }
}

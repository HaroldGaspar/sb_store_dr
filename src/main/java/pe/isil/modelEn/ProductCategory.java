package pe.isil.modelEn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Table(name = "product_category")
@Entity
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String name;
    private String description;
    private String imgUrl;

    //////////////////////////////////////////////////

        @OneToMany(mappedBy = "productCategory")
        private List<Product> productList;

    //////////////////////////////////////////////////


}

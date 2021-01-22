package pe.isil.modelEn;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Table(name = "client")
@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientId;
    private String firstName;
    private String lastName;
    private String user;
    private String password;

    //////////////////////////////////////////////////

        //[FK]
        @OneToOne(cascade = CascadeType.ALL)//auto persis
        @JoinColumn(name = "cartId")
        private Cart cart;

        @OneToMany(mappedBy = "client")
        private List<Bill> billList;

        @ManyToMany
        private Set<Role> roles;

    //////////////////////////////////////////////////


    public Client(Integer id, String firstName, String lastName, String user, String password, Cart cart) {
        this.clientId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.user = user;
        this.password = password;
        this.cart = cart;
    }
}
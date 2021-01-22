package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.modelEn.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
}

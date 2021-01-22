package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.modelEn.CartDetail;

import java.util.List;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Integer> {
    // nested exception is java.lang.IllegalArgumentException: Failed to create query for method public abstract
    //java.util.List pe.isil.repository.CartDetailRepository.findByCartId(java.lang.Integer)! No property id found for type Cart! Traversed path: CartDetail.cart.
    List<CartDetail> findByCartCartId(Integer id);
    List<CartDetail> deleteByProductProductId(Integer id);
}

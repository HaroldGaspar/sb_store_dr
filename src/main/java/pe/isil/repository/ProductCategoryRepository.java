package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.modelEn.ProductCategory;
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
}

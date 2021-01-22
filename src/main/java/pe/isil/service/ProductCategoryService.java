package pe.isil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.modelEn.ProductCategory;
import pe.isil.repository.ProductCategoryRepository;

import java.util.List;

@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public void createOrUpdate(ProductCategory pc){
        productCategoryRepository.save(pc);
    }

    public void delete(Integer id){
        productCategoryRepository.deleteById(id);
    }

    public ProductCategory findById(Integer id){
        return productCategoryRepository.findById(id).orElse(null);
    }

    public List<ProductCategory> findAll(){
        return productCategoryRepository.findAll();
    }


}

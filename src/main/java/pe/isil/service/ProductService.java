package pe.isil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.modelEn.Product;
import pe.isil.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository companyRepository;

    public void createOrUpdate(Product company){
        companyRepository.save(company);
    }

    public void delete(Integer id){
        companyRepository.deleteById(id);
    }

    public Product findById(Integer id){
        return companyRepository.findById(id).orElse(null);
    }

    public List<Product> findAll(){
        return companyRepository.findAll();
    }

    public List<Product> findByCategoryId(Integer categoryId){
        return companyRepository.findByProductCategoryCategoryId(categoryId);
    }

}

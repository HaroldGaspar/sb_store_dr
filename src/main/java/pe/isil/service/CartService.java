package pe.isil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.modelEn.Cart;
import pe.isil.repository.CartRepository;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository companyRepository;

    public void createOrUpdate(Cart company){
        companyRepository.save(company);
    }

    public void delete(Integer id){
        companyRepository.deleteById(id);
    }

    public Cart findById(Integer id){
        return companyRepository.findById(id).orElse(null);
    }
//    public List<Cart> findById(Integer id){
//        return companyRepository.findById(id);
//    }


    public List<Cart> findAll(){
        return companyRepository.findAll();
    }
}

package pe.isil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.isil.modelEn.CartDetail;
import pe.isil.modelEn.KeyCartDetail;
import pe.isil.repository.CartDetailRepository;

import java.util.List;

@Service
public class CartDetailService {
    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Autowired
    private CartService cartService;

    //can be return
    public void createOrUpdate(CartDetail company){
        cartDetailRepository.save(company);
    }

    @Transactional
    //HOW WORKS?
    public void deleteFromCart(Integer cartId,Integer productId){
        List<CartDetail> cartDetailList = findByCartId(cartId);
        //cartDetailList.
        cartDetailRepository.deleteByProductProductId(cartId);
    }

    //MUST FIX FOR ADMIT KCD INSTEAD INTEGER
    /*public CartDetail findById(KeyCartDetail id){
        return companyRepository.findById(id).orElse(null);
    }*/

    public List<CartDetail> findAll(){
        return cartDetailRepository.findAll();
    }

    //@Transactional(readOnly = true)
    public List<CartDetail> findByCartId(Integer id){
        return cartDetailRepository.findByCartCartId(id);
    }


}

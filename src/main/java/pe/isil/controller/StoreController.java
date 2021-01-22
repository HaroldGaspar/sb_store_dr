package pe.isil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.isil.modelEn.CartDetail;
import pe.isil.service.CartDetailService;
import pe.isil.service.CartService;
import pe.isil.service.ProductService;

@Controller
public class StoreController {


    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;
    @Autowired
    private CartDetailService cartDetailService;

    @GetMapping("/store")
    public String storeList(Model model){
        model.addAttribute("products",productService.findAll() );
        //model.addAttribute("cart", productService.findById(1));//proporcionar el carrito del cliente q esta en la sesion

        model.addAttribute("cartDetail", new CartDetail());
        return "store";
    }
/*
    @GetMapping("/cart")
    public String CartList(Model model){
        model.addAttribute("listDCart", cartDetailService.)
    }
 */
}

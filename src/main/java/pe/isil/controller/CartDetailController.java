package pe.isil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.modelEn.Cart;
import pe.isil.modelEn.CartDetail;
import pe.isil.modelEn.KeyCartDetail;
import pe.isil.modelEn.Product;
import pe.isil.service.CartDetailService;
import pe.isil.service.CartService;
import pe.isil.service.ClientService;
import pe.isil.service.ProductService;

@Controller
public class CartDetailController {

    @Autowired
    private CartDetailService cartDetailService;
    @Autowired
    private ClientService clientService;
    @Autowired private CartService cartService;
    @Autowired private ProductService productService;

    @GetMapping("/carts")
    public String cartList(Model model){
        model.addAttribute("cartDetails",cartDetailService.findAll() );
        return "cart";
    }

//    @GetMapping("/carts/add")
//    public String productAdd(Model model){
//        model.addAttribute("cart", new Cart());
//        return "cartsAdd";
//    }

    @PostMapping("/carts/save{productId}")
    public String productSave( @PathVariable Integer productId, CartDetail cartD){
        //new CartDetail();
        KeyCartDetail kcd = new KeyCartDetail(1, productId);
        cartD.setId(kcd);
        cartD.setCart(cartService.findById(1));
        cartD.setProduct(productService.findById(productId));

        System.out.println("kcd: "+kcd);
        //System.out.println("Cart Detail: "+cartDetailService.findById(kcd));
        cartDetailService.createOrUpdate(cartD);
        return "redirect:/store";
    }
/*
    @GetMapping("/carts/edit/{id}")
    public String productEdit(@PathVariable Integer id, Model model){
        model.addAttribute("cart", cartDetailService.findById(id));
        return "carts";
    }

    @GetMapping("/carts/{id}")
    public String cartList(@PathVariable Integer id,Model model){
        model.addAttribute("cartDetails",cartDetailService.findById(id) );
        return "carts";
    }

*/
    @Secured("ROLE_USER")
    @GetMapping("/myCart/{id}")
    public String cartListByCart(@PathVariable Integer id,Model model){
        model.addAttribute("myCartDetails",cartDetailService.findByCartId(id) );
        return "cart";
    }

    @Transactional
    @PostMapping("myCart/delete/{cartId}/{productId}")
    public String cartDetailDelete(@PathVariable Integer cartId,@PathVariable Integer productId){
    //DELETE BY CART AND PRODUCT
        cartDetailService.deleteFromCart(cartId, productId);
        return "redirect:/myCart/{cartId}";
    }
}

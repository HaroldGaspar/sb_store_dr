package pe.isil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.modelEn.Cart;
import pe.isil.modelEn.Client;
import pe.isil.service.CartService;
import pe.isil.service.ClientService;
import pe.isil.service.SecurityService;

//@Secured("ROLE_ADMIN")
@Controller
public class ClientController {

    @Autowired
    private ClientService cs;
    @Autowired
    private CartService cartService;
//    @Autowired
//    private SecurityService securityService;


    @GetMapping("/clients")
    public String clientsList(Model model){
        model.addAttribute("clients",cs.findAll() );
        return "clients";
    }

    @GetMapping("/clients/add")
    public String clientAdd(Model model){
        model.addAttribute("client", new Client());
        return "clientAdd";
    }

    @PostMapping("/clients/save")
    public String clientSave(Client c){
        c.setCart(new Cart());
        cs.createOrUpdate(c);
        System.out.println("customer = " + c);

        cartService.createOrUpdate(new Cart(c.getCart().getCartId(), c));
        //autologin
//        securityService.autoLogin(c.getUser(), c.getPassword());
        //STACKOVERFLOW//System.out.println("cart = " + cartService.findById(c.getCart().getCartId()));
        return "redirect:/store";
    }

    @GetMapping("/clients/edit/{id}")
    public String clientEdit(@PathVariable Integer id, Model model){
        model.addAttribute("client", cs.findById(id));
        return "clientAdd";
    }

    @GetMapping("clients/delete/{id}")
    public String clientDelete(@PathVariable Integer id){
        cs.delete(id);
        return "redirect:/clients";
    }
}

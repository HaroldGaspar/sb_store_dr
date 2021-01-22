package pe.isil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
//import pe.isil.model.User;
//import pe.isil.service.SecurityService;
//import pe.isil.service.UserService;

@Controller
@RequestMapping("/")
public class AppWeb {
/*
    private final UserService userService;
    private final SecurityService securityService;

    @Autowired
    public AppWeb(UserService userService, SecurityService securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }

    @PostMapping("registration")
    public String registerNewUser(User user){

        userService.registerNewUser(user);

        //autologin
        securityService.autoLogin(user.getUsername(), user.getPassword());

        return "redirect:/menu";
    }

 */

//    @GetMapping("login")
//    public String login() {
//        return "Ulogin";
//    }

    @GetMapping("login")
    public String login(@RequestParam(value = "error", required = false) String err,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model, Principal principal, RedirectAttributes attributes) {
        if (err != null){
            model.addAttribute("error", "ERROR DE ACCESO: Credenciales incorrectas");
        }
        if (logout != null){
            model.addAttribute("success", "SESSION FINALIZADA");
        }
        if (principal != null){
            attributes.addFlashAttribute("warning", "USTED YA HA INICIADO SESION");
            return "redirect:/store";
        }
        return "Ulogin";
    }

    @GetMapping("menu")
    public String menu() {
        return "menu";
    }




}

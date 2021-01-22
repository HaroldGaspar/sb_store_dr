package pe.isil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.isil.modelEn.Product;
import pe.isil.service.ProductCategoryService;
import pe.isil.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService pcService;

    @GetMapping("/products")
    public String productList(Model model,
                              @RequestParam(required = false) Integer categoryId){

        if (categoryId != null){
            model.addAttribute("products", productService.findByCategoryId(categoryId));
            return "products";
        }
        model.addAttribute("products",productService.findAll() );
        return "products";
    }

    @GetMapping("/products/add")
    public String productAdd(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("categories", pcService.findAll());
        return "productAdd";
    }

    @PostMapping("/products/save")
    public String productSave(Product product){
        productService.createOrUpdate(product);
        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public String productEdit(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("categories", pcService.findAll());
        return "productAdd";
    }

    @GetMapping("products/delete/{id}")
    public String employeeDelete(@PathVariable Integer id){
        productService.delete(id);
        return "redirect:/products";
    }

}

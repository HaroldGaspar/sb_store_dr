package pe.isil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.modelEn.ProductCategory;
import pe.isil.service.ProductCategoryService;

@Controller
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/categories")
    public String categoriesList(Model model){
        model.addAttribute("categories", productCategoryService.findAll());
        return "categories";
    }

    @GetMapping("/categories/add")
    public String CategoryAdd(Model model){
        model.addAttribute("category", new ProductCategory());
        return "categoryAdd";
    }

    @PostMapping("/categories/save")
    public String CategorySave(ProductCategory category){
        productCategoryService.createOrUpdate(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/edit/{id}")
    public String CategoryEdit(@PathVariable Integer id, Model model){
        model.addAttribute("category", productCategoryService.findById(id));
        return "categoryAdd";
    }

    @GetMapping("categories/delete/{id}")
    public String companyDelete(@PathVariable Integer id){
        productCategoryService.delete(id);
        return "redirect:/categories";
    }

}

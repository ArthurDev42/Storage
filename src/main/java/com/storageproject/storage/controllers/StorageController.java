package com.storageproject.storage.controllers;

import com.storageproject.storage.models.Provider;
import com.storageproject.storage.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class StorageController {
    private final ProductServiceImpl productService;

    public StorageController(ProductServiceImpl productService) {
        this.productService = productService;
    }


    @GetMapping("/")
    public String getStorageMainPage(Model model) {
        model.addAttribute("allProducts", productService.getAllProducts());
        return "index";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("allProviders", productService.getAllProviders());
        return "product-addition";
    }
    @PostMapping("/add")
    public String postProduct(@RequestParam String title, @RequestParam int quantity, @RequestParam Date releaseDate,
                              @RequestParam long upc, @RequestParam String manufacturer, @RequestParam Provider provider) {
        productService.saveProduct(title, quantity, releaseDate, upc, manufacturer, provider);
        return "redirect:/";
    }
    @GetMapping("/info/{id}")
    public String detailsInfo(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("product", productService.getProductByID(id));
        return "product-info";
    }

    @GetMapping("/info/{id}/edit")
    public String editDisplayProduct(@PathVariable(value = "id") long id, Model model, Model model2) {
        model.addAttribute("product", productService.getProductByID(id));
        model2.addAttribute("allProviders", productService.getAllProviders());
        return "product-edit";
    }

    @PostMapping("/info/{id}/edit")
    public String editUpdateProduct(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam int quantity, @RequestParam Date releaseDate,
                                    @RequestParam long upc, @RequestParam String manufacturer, @RequestParam Provider provider) {
        productService.updateProduct(id, title, quantity, releaseDate, upc, manufacturer, provider);
        return "redirect:/info/{id}";
    }

    @PostMapping("/info/{id}/delete")
    public String deleteProduct(@PathVariable(value = "id") long id, Model model) {
        productService.deleteProductById(id);
        return "redirect:/";
    }

    @GetMapping("/errorpage")
    public String viewErrorPage() {
        return "/errorpage";
    }
}
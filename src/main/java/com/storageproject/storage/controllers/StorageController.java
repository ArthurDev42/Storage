package com.storageproject.storage.controllers;

import com.storageproject.storage.models.Product;
import com.storageproject.storage.models.Provider;
import com.storageproject.storage.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Optional;

@Controller
public class StorageController {
    @Autowired
    private final ProductServiceImpl productService;

    public StorageController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/main")
    public String getStorageMainPage(Model model) {
        model.addAttribute("allProducts", productService.getAllProducts());
        return "storage-main";
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
        return "redirect:/main";
    }
    @GetMapping("/info/{id}")
    public String detailsInfo(@PathVariable(value = "id") long id, Model model) {
//        if(!productsRepository.existsById(id)) {
//            return "redirect:/errorpage";
//        }
        model.addAttribute("product", productService.getProductByID(id));
        return "product-info";
    }

    @GetMapping("/info/{id}/edit")
    public String editDisplayProduct(@PathVariable(value = "id") long id, Model model, Model model2) {
//        if(!productsRepository.existsById(id)) {
//            return "redirect:/errorpage";
//        }
        model.addAttribute("product", productService.getProductByID(id));
        model2.addAttribute("allProviders", productService.getAllProviders());
        return "product-edit";
    }

    @PostMapping("/info/{id}/edit")
    public String editUpdateProduct(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam int quantity, @RequestParam Date releaseDate,
                                    @RequestParam long upc, @RequestParam String manufacturer, @RequestParam Provider provider) {
//        if(!productsRepository.existsById(id)) {
//            return "redirect:/errorpage";
//        }
        productService.updateProduct(id, title, quantity, releaseDate, upc, manufacturer, provider);
        return "redirect:/info/{id}";
    }

    @PostMapping("/info/{id}/delete")
    public String deleteProduct(@PathVariable(value = "id") long id, Model model) {
//        if(!productsRepository.existsById(id)) {
//            return "redirect:/errorpage";
//        }
        productService.deleteProductById(id);
        return "redirect:/main";
    }

    @GetMapping("/errorpage")
    public String viewErrorPage() {
        return "/errorpage";
    }
}
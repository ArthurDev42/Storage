package com.storageproject.storage.controllers;

import com.storageproject.storage.models.Product;
import com.storageproject.storage.models.Provider;
import com.storageproject.storage.repositories.ProductRepository;
import com.storageproject.storage.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Optional;

@Controller
public class StorageController {
    @Autowired
    private final ProductRepository productsRepository;
    private final ProviderRepository providerRepository;

    public StorageController(ProductRepository productsRepository, ProviderRepository providerRepository) {
        this.productsRepository = productsRepository;
        this.providerRepository = providerRepository;
    }

    @GetMapping("/main")
    public String index(Model model) {
        Iterable<Product> products = productsRepository.findAll();
        model.addAttribute("allProducts", products);
        return "storage-main";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        Iterable<Provider> providers = providerRepository.findAll();
        model.addAttribute("allProviders", providers);
        return "product-addition";
    }
    @PostMapping("/add")
    public String postProduct(@RequestParam String title, @RequestParam int quantity, @RequestParam Date releaseDate,
                              @RequestParam long upc, @RequestParam String manufacturer, @RequestParam Provider provider) {
        Product product = new Product(title, quantity, releaseDate, upc, manufacturer, provider);
        productsRepository.save(product);
        return "redirect:/main";
    }
        @GetMapping("/info/{id}")
    public String detailsInfo(@PathVariable(value = "id") long id, Model model) {
        if(!productsRepository.existsById(id)) {
            return "redirect:/errorpage";
        }
        Optional<Product> optionalProducts = productsRepository.findById(id);
        Product product = optionalProducts.get();
        model.addAttribute("product", product);
        return "product-info";
    }

    @GetMapping("/info/{id}/edit")
    public String editDisplayProduct(@PathVariable(value = "id") long id, Model model) {
        if(!productsRepository.existsById(id)) {
            return "redirect:/errorpage";
        }
        Optional<Product> optionalProducts = productsRepository.findById(id);
        Product product = optionalProducts.get();
        model.addAttribute("product", product);
        return "product-edit";
    }

    @PostMapping("/info/{id}/edit")
    public String editUpdateProduct(@PathVariable(value = "id") long id, @RequestParam String title,
                                    @RequestParam String manufacturer) {
        if(!productsRepository.existsById(id)) {
            return "redirect:/errorpage";
        }
        Product product = productsRepository.findById(id).orElseThrow();
        product.setTitle(title);
        product.setManufacturer(manufacturer);
        productsRepository.save(product);
        return "redirect:/info/{id}";
    }

    @PostMapping("/info/{id}/delete")
    public String deleteProduct(@PathVariable(value = "id") long id, Model model) {
        if(!productsRepository.existsById(id)) {
            return "redirect:/errorpage";
        }
        productsRepository.deleteById(id);
        return "redirect:/main";
    }

    @GetMapping("/errorpage")
    public String viewErrorPage() {
        return "/errorpage";
    }
}
package com.storageproject.storage.controllers;

import com.storageproject.storage.models.Product;
import com.storageproject.storage.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class StorageController {
    @Autowired
    private final ProductsRepository productsRepository;

    public StorageController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Product> products = productsRepository.findAll();
        model.addAttribute("allProducts", products);
        return "index";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        return "addition";
    }

    @PostMapping("/add")
    public String postProduct(@RequestParam String title,@RequestParam String manufacturer) {
        Product product = new Product(title, manufacturer);
        productsRepository.save(product);
        return "redirect:/";
    }

    @GetMapping("/info/{id}")
    public String detailsInfo(@PathVariable(value = "id") long id, Model model) {
        if(!productsRepository.existsById(id)) {
            return "redirect:/errorpage";
        }
        Optional<Product> optionalProducts = productsRepository.findById(id);
        Product product = optionalProducts.get();
        model.addAttribute("product", product);
        return "info";
    }

    @GetMapping("/info/{id}/edit")
    public String editDisplayProduct(@PathVariable(value = "id") long id, Model model) {
        if(!productsRepository.existsById(id)) {
            return "redirect:/errorpage";
        }
        Optional<Product> optionalProducts = productsRepository.findById(id);
        Product product = optionalProducts.get();
        model.addAttribute("product", product);
        return "edit";
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
        return "redirect:/";
    }

    @PostMapping("/info/{id}/delete")
    public String deleteProduct(@PathVariable(value = "id") long id, Model model) {
        if(!productsRepository.existsById(id)) {
            return "redirect:/errorpage";
        }
        productsRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/errorpage")
    public String viewErrorPage(Model model) {
        return "/errorpage";
    }
}
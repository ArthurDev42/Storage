package com.storageproject.storage.services;

import com.storageproject.storage.models.Product;
import com.storageproject.storage.models.Provider;
import com.storageproject.storage.repositories.ProductRepository;
import com.storageproject.storage.repositories.ProviderRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productsRepository;
    private final ProviderRepository providerRepository;

    public ProductServiceImpl(ProductRepository productsRepository, ProviderRepository providerRepository) {
        this.productsRepository = productsRepository;
        this.providerRepository = providerRepository;
    }

    @Override
    public Iterable<Product> getAllProducts() {
        Iterable<Product> products = productsRepository.findAll();
        return products;
    }

    @Override
    public Iterable<Provider> getAllProviders() {
        Iterable<Provider> providers = providerRepository.findAll();
        return providers;
    }

    @Override
    public void saveProduct(String title, int quantity, Date releaseDate, long upc, String manufacturer, Provider provider) {
            String employee = SecurityContextHolder.getContext().getAuthentication().getName();
            Product product = new Product(title, quantity, releaseDate, upc, manufacturer, provider, employee);
            productsRepository.save(product);
    }

    @Override
    public Product getProductByID(long id) {
        Optional<Product> optionalProducts = productsRepository.findById(id);
        Product product = optionalProducts.get();
        return product;
    }

    @Override
    public void updateProduct(long id, String title, int quantity, Date releaseDate, long upc, String manufacturer, Provider provider) {
        Product product = productsRepository.findById(id).orElseThrow();
        product.setTitle(title);
        product.setQuantity(quantity);
        product.setReleaseDate(releaseDate);
        product.setUpc(upc);
        product.setManufacturer(manufacturer);
        product.setProvider(provider);
        productsRepository.save(product);
    }

    @Override
    public void deleteProductById(long id) {
        productsRepository.deleteById(id);
    }

}

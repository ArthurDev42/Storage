package com.storageproject.storage.services;

import com.storageproject.storage.models.Product;
import com.storageproject.storage.repositories.ProductRepository;

import java.util.Optional;

public interface ProductService {

    public ProductRepository getProductRepository();
    public Optional<Product> findById(Long id);

}

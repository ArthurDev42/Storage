package com.storageproject.storage.services;

import com.storageproject.storage.models.Product;
import com.storageproject.storage.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public ProductRepository getProductRepository() {
        return null;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

}

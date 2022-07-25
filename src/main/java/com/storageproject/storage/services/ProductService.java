package com.storageproject.storage.services;

import com.storageproject.storage.models.Product;
import com.storageproject.storage.models.Provider;
import com.storageproject.storage.repositories.ProductRepository;

import java.sql.Date;
import java.util.Optional;

public interface ProductService {

    public Iterable<Product> getAllProducts();
    public Iterable<Provider> getAllProviders();
    public void saveProduct(String title, int quantity, Date releaseDate, long upc, String manufacturer, Provider provider);

    public Product getProductByID(long id);
//    public Optional<Product> findById(Long id);

    void updateProduct(long id, String title, int quantity, Date releaseDate, long upc, String manufacturer, Provider provider);

    void deleteProductById(long id);
}

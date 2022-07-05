package com.storageproject.storage.repository;

import com.storageproject.storage.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository<Product, Long> {
}

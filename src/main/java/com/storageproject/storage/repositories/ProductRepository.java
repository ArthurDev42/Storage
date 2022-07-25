package com.storageproject.storage.repositories;

import com.storageproject.storage.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}

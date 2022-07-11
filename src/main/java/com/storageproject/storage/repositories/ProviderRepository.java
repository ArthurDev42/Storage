package com.storageproject.storage.repositories;

import com.storageproject.storage.models.Provider;
import org.springframework.data.repository.CrudRepository;

public interface ProviderRepository extends CrudRepository<Provider, Long> {
}

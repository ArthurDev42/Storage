package com.storageproject.storage.services;

import com.storageproject.storage.exceptions.EmployeeIsAlreadyExist;
import com.storageproject.storage.models.Provider;
import com.storageproject.storage.repositories.ProviderRepository;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl implements ProviderService {
    private ProviderRepository providerRepository;
    public ProviderServiceImpl(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }



    public Provider registrationNewProvider(String title, String contacts, String data) throws EmployeeIsAlreadyExist {
        Provider employee = new Provider(title, contacts, data);

        return providerRepository.save(employee);
    }
}

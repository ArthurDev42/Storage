package com.storageproject.storage.services;

import com.storageproject.storage.exceptions.EmployeeIsAlreadyExist;
import com.storageproject.storage.models.Provider;

public interface ProviderService {

    public Provider registrationNewProvider(String title, String contacts, String data) throws EmployeeIsAlreadyExist;


}

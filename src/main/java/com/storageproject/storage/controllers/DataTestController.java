package com.storageproject.storage.controllers;

import com.storageproject.storage.exceptions.EmployeeIsAlreadyExist;
import com.storageproject.storage.security.EmployeeServiceImpl;
import com.storageproject.storage.services.ProductServiceImpl;
import com.storageproject.storage.services.ProviderServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataTestController {

    private final EmployeeServiceImpl employeeServiceImpl;
    private final ProviderServiceImpl providerServiceImpl;
    private final ProductServiceImpl productService;

    public DataTestController(EmployeeServiceImpl employeeServiceImpl, ProviderServiceImpl providerServiceImpl, ProductServiceImpl productService) {
        this.employeeServiceImpl = employeeServiceImpl;
        this.providerServiceImpl = providerServiceImpl;
        this.productService = productService;
    }



    @GetMapping("/test")
    public String getTestData() {
        try {
            providerServiceImpl.registrationNewProvider("title of first", "contacts", "some data");
            providerServiceImpl.registrationNewProvider("title of second", "contacts ", "some data");
            employeeServiceImpl.registration("Sam", "admin", "ADMIN");
            employeeServiceImpl.registration("Mike", "user", "USER");
        } catch (EmployeeIsAlreadyExist e) {
            throw new RuntimeException(e);
        }
        return "login";
    }
}

package com.storageproject.storage.services;

import com.storageproject.storage.exceptions.EmployeeIsAlreadyExist;
import com.storageproject.storage.models.Employee;

public interface EmployeeService {

    public Employee registration(String login, String password, String info) throws EmployeeIsAlreadyExist;
}

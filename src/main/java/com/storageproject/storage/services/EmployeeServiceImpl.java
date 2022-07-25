package com.storageproject.storage.services;

import com.storageproject.storage.exceptions.EmployeeIsAlreadyExist;
import com.storageproject.storage.models.Employee;
import com.storageproject.storage.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee registration(String login, String password, String info) throws EmployeeIsAlreadyExist {
        Employee employee = new Employee(login, password, info);
//        if(employeeRepository.findByLogin(employee.getLogin()) != null) {
//            throw new EmployeeIsAlreadyExist("Employee is already exist");
//        }
        return employeeRepository.save(employee);
    }
}

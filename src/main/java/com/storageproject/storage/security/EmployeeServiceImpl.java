package com.storageproject.storage.security;

import com.storageproject.storage.exceptions.EmployeeIsAlreadyExist;
import com.storageproject.storage.models.Employee;
import com.storageproject.storage.models.Role;
import com.storageproject.storage.repositories.EmployeeRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service("employeeServiceImpl")
public class EmployeeServiceImpl implements UserDetailsService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee registration(String login, String password, String role) throws EmployeeIsAlreadyExist {
        BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder(12, new SecureRandom());
        Employee employee = new Employee(login, bcpe.encode(password), Role.valueOf(role));
        return employeeRepository.save(employee);
    }

    public Role[] getAllRoles() {
        return Role.values();
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByLogin(login).orElseThrow();
        return SecurityEmployee.fromUser(employee);
    }
}

package com.storageproject.storage.controllers;

import com.storageproject.storage.services.EmployeeServiceImpl;
import com.storageproject.storage.services.ProviderServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeesController {

    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeesController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register-employee";
    }

    @PostMapping("/register")
    public String postRegister(@RequestParam String login,
                                               @RequestParam String password,  @RequestParam String info) {
        try {
            employeeServiceImpl.registration(login, password, info);
            return "redirect:/main";
        } catch (Exception e) {
            return "redirect:/errorpage";
        }
    }

}

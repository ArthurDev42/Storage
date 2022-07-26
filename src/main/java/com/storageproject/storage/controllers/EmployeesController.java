package com.storageproject.storage.controllers;

import com.storageproject.storage.security.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeesController {

    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeesController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("allRoles", employeeServiceImpl.getAllRoles());
        return "register-employee";
    }

    @PostMapping("/register")
    public String postRegister(@RequestParam String login, @RequestParam String password, @RequestParam String role) {
        try {
            employeeServiceImpl.registration(login, password, role);
            return "redirect:/";
        } catch (Exception e) {
            return "redirect:/errorpage";
        }
    }

}

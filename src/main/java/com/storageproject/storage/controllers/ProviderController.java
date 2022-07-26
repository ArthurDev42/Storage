package com.storageproject.storage.controllers;

import com.storageproject.storage.services.ProviderServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProviderController {

    private final ProviderServiceImpl providerServiceImpl;


    public ProviderController(ProviderServiceImpl providerServiceImpl) {
        this.providerServiceImpl = providerServiceImpl;
    }


    @GetMapping("/provider-addition")
    public String getProviderAddiction() {
        return "/provider-addition";
    }

    @PostMapping("/provider-addition")
    public String postProviderAddiction(@RequestParam String title,
                                        @RequestParam String contacts,  @RequestParam String data) {
        try {
            providerServiceImpl.registrationNewProvider(title, contacts, data);
            return "redirect:/";
        } catch (Exception e) {
            return "redirect:/errorpage";
        }
    }


}

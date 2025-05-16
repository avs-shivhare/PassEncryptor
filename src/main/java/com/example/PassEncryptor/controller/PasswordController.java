package com.example.PassEncryptor.controller;




import com.example.PassEncryptor.model.Credential;
import com.example.PassEncryptor.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passwords")
public class PasswordController {

    @Autowired
    private PasswordService passwordService ;

    @PostMapping("/save")
    public String saveCredential(
            @RequestParam String username ,
            @RequestParam String service ,
            @RequestParam String password) {
        passwordService.saveCredential(username , service , password );
        return "Password saved succesfully";
    }

    @GetMapping("/get")
    public String getPassword(@RequestParam String username , @RequestParam String service) {
        return passwordService.getPassword(username , service);
    }

    @GetMapping("/all")
    public List<Credential> getAllCredential() {
        return passwordService.getALlCredential();
    }
}

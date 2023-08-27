package com.example.authservice.controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/api/auth/login")
@RestController
public class LoginController {
    @PostMapping
    public String signInWithGoogle(@RequestParam String idToken){
        System.out.println(idToken);
        return idToken;
    }
}

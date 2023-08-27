package com.example.authservice.controller;

import com.example.authservice.service.EmailStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/api/auth/emailStatus")
@RestController
public class EmailStatusController {
    @Autowired
    private EmailStatusService emailStatusService;

    @GetMapping("/{email}")
    public boolean emailExists(@PathVariable String email) {
        emailStatusService.emailExists(email);
        return true;
    }

    @GetMapping("/{email}/isVerified")
    public boolean isEmailVerified(@PathVariable String email) {
        emailStatusService.isEmailVerified(email);
        return true;
    }
}

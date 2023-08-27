package com.example.authservice.service.impl;

import com.example.authservice.entity.Credentials;
import com.example.authservice.repository.CredentialRepository;
import com.example.authservice.repository.UserRepository;
import com.example.authservice.service.EmailStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class EmailStatusServiceImpl implements EmailStatusService {
//    private UserRepository userRepository;

    @Autowired
        private CredentialRepository credentialRepository;
    public boolean emailExists(@PathVariable String email) {
        return credentialRepository.existsByEmail(email);
    }

    public boolean isEmailVerified(@PathVariable String email) {
        return true;
    }
}

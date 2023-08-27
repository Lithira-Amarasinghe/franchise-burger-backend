package com.example.authservice.service;

import com.example.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public interface EmailStatusService {

    boolean emailExists(@PathVariable String email);

    boolean isEmailVerified(@PathVariable String email);
}

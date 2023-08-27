package com.example.authservice.repository;

import com.example.authservice.entity.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepository extends JpaRepository<Credentials, Integer> {
    boolean existsByEmail(String email);
}

package com.example.Authentication.repositories;

import com.example.Authentication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface userRepository extends JpaRepository<User, UUID> {
}

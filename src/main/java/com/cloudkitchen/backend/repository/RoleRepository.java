package com.cloudkitchen.backend.repository;

import com.cloudkitchen.backend.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Roles,Long> {
    Optional<Roles> findByRole (String role);
}

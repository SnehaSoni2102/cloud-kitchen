package com.cloudkitchen.backend.repository;

import com.cloudkitchen.backend.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles,Long> {
}

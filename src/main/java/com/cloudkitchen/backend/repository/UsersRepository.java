package com.cloudkitchen.backend.repository;

import com.cloudkitchen.backend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {
}

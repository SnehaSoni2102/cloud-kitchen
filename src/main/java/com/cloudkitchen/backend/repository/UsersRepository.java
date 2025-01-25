package com.cloudkitchen.backend.repository;

import com.cloudkitchen.backend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByUserName (String userName);
    Optional<Users> findByEmail (String email);
    Optional<Users> findByUserNameOrEmail (String userName, String email);

    Boolean existsByUserName(String userName);
    Boolean existsByEmail(String email);
}

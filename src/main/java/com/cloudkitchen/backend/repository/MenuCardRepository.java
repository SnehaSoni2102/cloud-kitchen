package com.cloudkitchen.backend.repository;

import com.cloudkitchen.backend.model.MenuCards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface MenuCardRepository extends JpaRepository<MenuCards,Long> {
}

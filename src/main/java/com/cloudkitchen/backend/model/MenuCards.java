package com.cloudkitchen.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "menu_cards")
public class MenuCards {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private String imageURL;

     // Nullable is fine, just make sure you are handling nulls properly
    private int ratings;

    private List<String> cuisine;
}

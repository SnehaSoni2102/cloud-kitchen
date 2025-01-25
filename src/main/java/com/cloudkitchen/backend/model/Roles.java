package com.cloudkitchen.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "roles")
@Data
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 60)
    private String role;

    public long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }
}

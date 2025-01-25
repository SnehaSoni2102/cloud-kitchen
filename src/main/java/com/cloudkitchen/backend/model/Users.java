package com.cloudkitchen.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "userName", nullable = false, unique = true)
    private String userName;
    @Column(name="email",nullable = false,unique = true)
    private String email;
    private String password;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns  = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Roles> roles;
}

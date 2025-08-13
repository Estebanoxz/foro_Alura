package com.ForoAlura.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;

import java.util.Set;

@Entity
@Table(name="Usuarios")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ElementCollection(fetch =FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;


}

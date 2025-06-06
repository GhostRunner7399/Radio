package org.example.radio.User.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String identifier;

    private String firstname;

    private String username;

    @Column(unique = true)
    private String email;

    private String password;

    private String pin;
}

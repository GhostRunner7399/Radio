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

    @Column
    public String firstname;

    @Column
    public String username;

    @Column(unique = true)
    public String email;

    @Column
    public String password;


}

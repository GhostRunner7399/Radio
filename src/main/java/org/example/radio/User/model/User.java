package org.example.radio.User.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @Email(message = "Ta mal ese email manito")
    private String email;

    @NotBlank(message = "Contrasena obligatoriamente obligatoria")
    private String password;

    @Pattern(regexp = "\\d{4}", message = "4 digitos o explota tu compu")
    private String pin;
}

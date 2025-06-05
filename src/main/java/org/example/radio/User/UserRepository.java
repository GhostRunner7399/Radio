package org.example.radio.User;

import org.example.radio.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Usar los métodos predeterminados de eliminación
    void deleteById(Long id);  // Usamos Long porque es el tipo de id de la entidad User

    void deleteByIdentifier(String identifier);

    Optional<User> findByIdentifier(String identifier);  // Correcto, buscando por identifier que es String

    void deleteByidentifier(String identifier);

    }
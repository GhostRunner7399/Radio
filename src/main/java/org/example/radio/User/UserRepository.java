package org.example.radio.User;

import org.example.radio.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByIdentifier(String identifier);

    void deleteByIdentifier(String identifier);

}

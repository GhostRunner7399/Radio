package org.example.radio.User;

import org.example.radio.User.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User findbyIdentifier(String identifier) {
        Optional<User> user = userRepository.findByIdentifier(identifier);
        return user.orElseThrow(() -> new RuntimeException("User not found"));  // Lanza una excepción si no se encuentra
    }


    public User CreateUser(User user) {
        return userRepository.save(user);
    }

    public User UpdateUser(User user) {
        return userRepository.save(user);
    }

    public void DeleteUser(String identifier) {
        userRepository.deleteByidentifier((identifier));
    }



}

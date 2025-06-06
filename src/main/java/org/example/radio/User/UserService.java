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
        return user.orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User CreateUser(User user) {
        return userRepository.save(user);
    }

    public User UpdateUser(User user) {
        return userRepository.save(user);
    }

    public void DeleteUser(String identifier) {
        userRepository.deleteByIdentifier(identifier);
    }

    // Método para validar PIN
    public boolean validatePin(String identifier, String inputPin) {
        Optional<User> userOptional = userRepository.findByIdentifier(identifier);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        User user = userOptional.get();

        if (user.getPin() == null) {
            throw new RuntimeException("sin pin sos tico");
        }

        return user.getPin().equals(inputPin);
    }
}

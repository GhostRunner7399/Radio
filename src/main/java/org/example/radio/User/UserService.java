package org.example.radio.User;

import org.example.radio.User.model.User;
import org.example.radio.exception.InvalidPinException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.radio.exception.UserNotFoundException;
import org.example.radio.exception.PinMismatchException;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



    public User findbyIdentifier(String identifier) {
        return userRepository.findByIdentifier(identifier)
                .orElseThrow(() -> new UserNotFoundException("El mae: " + identifier +" no exite loco" ));
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


    public boolean validatePin(String identifier, String inputPin) {
        validatePinFormat(inputPin);  // Validación explícita adicional

        User user = findbyIdentifier(identifier);

        if (user.getPin() == null) {
            throw new PinMismatchException("El usuario '" + identifier + "' no tiene PIN configurado.");
        }

        if (!user.getPin().equals(inputPin)) {
            throw new PinMismatchException("PIN inválido para el usuario '" + identifier + "'.");
        }

        return true;
    }

    private void validatePinFormat(String pin) {
        if (pin == null || !pin.matches("\\d{4}")) {
            throw new InvalidPinException("PIN inválido: debe contener exactamente 4 dígitos numéricos.");
        }
    }
}
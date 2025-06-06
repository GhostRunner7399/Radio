package org.example.radio.User;

import jakarta.validation.Valid;
import org.example.radio.User.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{identifier}")
    public User findUserByIdentifier(@PathVariable("identifier") String identifier) {
        return userService.findbyIdentifier(identifier);
    }


    @PostMapping("/create")
    public User createUser(@Valid @RequestBody User user) {
        return userService.CreateUser(user);
    }

    @DeleteMapping("/delete/{identifier}")
    public void deleteUserById(@PathVariable String identifier) {
        userService.DeleteUser(identifier);
    }

    @PatchMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.UpdateUser(user);
    }

    @PostMapping("/validate-pin")
    public boolean validatePin(@RequestBody PinValidationRequest request) {
        return userService.validatePin(request.getIdentifier(), request.getPin());
    }

    public static class PinValidationRequest {
        private String identifier;
        private String pin;

        public String getIdentifier() {
            return identifier;
        }
        public void setIdentifier(String identifier) {
            this.identifier = identifier;
        }

        public String getPin() {
            return pin;
        }
        public void setPin(String pin) {
            this.pin = pin;
        }
    }
}
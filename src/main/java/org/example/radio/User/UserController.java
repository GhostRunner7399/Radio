package org.example.radio.User;

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
    public User createUser(@RequestBody User user) {
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
}

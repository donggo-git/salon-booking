package dongcom.controller;

import java.lang.reflect.Executable;
import java.util.List;
import java.util.Optional;

import dongcom.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import dongcom.modal.User;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/api/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PutMapping("/api/users/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") Long id) throws Exception {
        Optional<User> otp = userRepository.findById(id);
        if (otp.isEmpty())
            throw new Exception("user not found with id " + id);

        User existingUser = otp.get();
        existingUser.setFullName(user.getFullName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());
        existingUser.setRole(user.getRole());

        return userRepository.save(existingUser);
    };

    @GetMapping("/api/users/{id}")
    public User getUserById(@PathVariable("id") Long id) throws Exception {
        Optional<User> otp = userRepository.findById(id);
        if (otp.isPresent()) {
            return otp.get();
        }
        throw new Exception("user not found");
    };

    @DeleteMapping("api/users/{id}")
    public String deleteUserById(@PathVariable("id") Long id) throws Exception {
        Optional<User> otp = userRepository.findById(id);
        if (otp.isEmpty()) {
            throw new Exception("user not found with id " + id);
        }

        userRepository.deleteById(otp.get().getId());
        return "User is deleted";
    }
}

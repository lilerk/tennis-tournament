package a1.controller;

import a1.dto.UserDTO;
import a1.model.User;
import a1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOwnAccount(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.badRequest().body("User not found");
        }

        User user = optionalUser.get();

        if (userDTO.getUsername() != null && !userDTO.getUsername().isEmpty()) {
            Optional<User> existingByUsername = userRepository.findByUsername(userDTO.getUsername());
            if (existingByUsername.isPresent() && !existingByUsername.get().getId().equals(user.getId())) {
                return ResponseEntity.badRequest().body("Username is already taken by another user.");
            }
            user.setUsername(userDTO.getUsername());
        }

        if (userDTO.getEmail() != null && !userDTO.getEmail().isEmpty()) {
            Optional<User> existingByEmail = userRepository.findByEmail(userDTO.getEmail());
            if (existingByEmail.isPresent() && !existingByEmail.get().getId().equals(user.getId())) {
                return ResponseEntity.badRequest().body("Email is already taken by another user.");
            }
            user.setEmail(userDTO.getEmail());
        }

        if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
            user.setPassword(userDTO.getPassword());
        }

        userRepository.save(user);
        return ResponseEntity.ok("Account updated successfully");
    }

}


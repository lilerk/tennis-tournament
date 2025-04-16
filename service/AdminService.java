package a1.service;

import a1.dto.UserDTO;
import a1.model.User;
import a1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (userDTO.getUsername() != null && !userDTO.getUsername().isEmpty()) {
            Optional<User> existingByUsername = userRepository.findByUsername(userDTO.getUsername());
            if (existingByUsername.isPresent() && !existingByUsername.get().getId().equals(user.getId())) {
                throw new RuntimeException("Username is already taken by another user.");
            }
            user.setUsername(userDTO.getUsername());
        }

        if (userDTO.getEmail() != null && !userDTO.getEmail().isEmpty()) {
            Optional<User> existingByEmail = userRepository.findByEmail(userDTO.getEmail());
            if (existingByEmail.isPresent() && !existingByEmail.get().getId().equals(user.getId())) {
                throw new RuntimeException("Email is already taken by another user.");
            }
            user.setEmail(userDTO.getEmail());
        }


        if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
            user.setPassword(userDTO.getPassword());
        }

        return userRepository.save(user);
    }



    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}


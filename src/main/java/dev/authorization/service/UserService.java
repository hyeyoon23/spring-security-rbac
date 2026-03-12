package dev.authorization.service;

import dev.authorization.model.User;
import dev.authorization.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getMyData(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

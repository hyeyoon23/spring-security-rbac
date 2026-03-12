package dev.authorization.service;

import dev.authorization.model.Authority;
import dev.authorization.model.User;
import dev.authorization.repository.UserRepository;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    // 회원가입
    public void signup(String username, String password, String position) {

        if (userRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("이미 존재하는 username입니다.");
        }

        // 암호화
        String encodedPassword = passwordEncoder.encode(password);

        User user = new User(username, encodedPassword, position);

        user.addAuthority(new Authority("USER"));

        userRepository.save(user);
    }

    // 로그인
    public void login(String username, String password) {

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(username, password);

        authenticationManager.authenticate(token);
    }
}
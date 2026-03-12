package dev.authorization.controller;

import dev.authorization.service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // 회원가입
    @PostMapping("/signup")
    public String signup(@RequestBody Map<String, String> request) {

        authService.signup(
                request.get("username"),
                request.get("password"),
                request.get("position")
        );

        return "회원가입 성공";
    }

    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> request) {

        authService.login(
                request.get("username"),
                request.get("password")
        );

        return "로그인 성공";
    }
}
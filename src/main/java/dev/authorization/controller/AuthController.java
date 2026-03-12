package dev.authorization.controller;

import dev.authorization.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // 회원가입
    @PostMapping("/signin")
    public String signup(@RequestParam String username,
                         @RequestParam String password,
                         @RequestParam String position) {

        authService.signup(username, password, position);

        return "redirect:/mypage";
    }

    // 로그인
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        authService.login(username, password);

        return "redirect:/mypage";
    }
}
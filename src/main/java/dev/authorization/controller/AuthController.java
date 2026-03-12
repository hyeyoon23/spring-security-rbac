package dev.authorization.controller;

import dev.authorization.service.AuthService;
import jakarta.servlet.http.HttpSession;
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
                         @RequestParam String position,
                         @RequestParam String authority) {

        authService.signup(username, password, position, authority);

        return "redirect:/login";
    }

    // 로그인
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session) {

        authService.login(username, password, session);

        return "redirect:/mypage";
    }
}
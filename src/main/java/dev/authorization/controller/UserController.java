package dev.authorization.controller;

import dev.authorization.model.User;
import dev.authorization.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/mypage")
    public String myPage(Model model, Authentication authentication) {

        String username = authentication.getName();

        User user = userService.getMyData(username);

        model.addAttribute("user", user);

        return "mypage";
    }
}
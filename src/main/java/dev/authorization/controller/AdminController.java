package dev.authorization.controller;

import dev.authorization.model.User;
import dev.authorization.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    @GetMapping("/adminpage")
    public String adminPage(Model model) {

        List<User> users = userService.getAllUsers();

        model.addAttribute("users", users);

        return "adminpage";
    }
}

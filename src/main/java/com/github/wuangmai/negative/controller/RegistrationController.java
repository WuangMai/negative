package com.github.wuangmai.negative.controller;

import com.github.wuangmai.negative.model.User;
import com.github.wuangmai.negative.service.UserManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final UserManagerService userManagerService;

    public RegistrationController(UserManagerService userManagerService) {
        this.userManagerService = userManagerService;
    }

    @GetMapping
    public String showRegPage(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping
    public String processRegistration(User user){
        userManagerService.registerUser(user);
        return "redirect:/login";
    }
}

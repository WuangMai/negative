package com.github.wuangmai.negative.controller;

import com.github.wuangmai.negative.model.User;
import com.github.wuangmai.negative.service.UserManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final UserManagerService userManagerService;

    public RegistrationController(UserManagerService userManagerService) {
        this.userManagerService = userManagerService;
    }

    @GetMapping
    public String showRegPage(Model model) {
        model.addAttribute("user", new User());
        return "home/register";
    }

    @PostMapping
    public String processRegistration(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "home/register";
        userManagerService.registerUser(user);
        return "home/login";
    }
}

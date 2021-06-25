package com.github.wuangmai.negative.controller;

import com.github.wuangmai.negative.model.Like;
import com.github.wuangmai.negative.model.User;
import com.github.wuangmai.negative.repository.LikeRepository;
import com.github.wuangmai.negative.repository.UserRepository;
import com.sun.xml.bind.v2.TODO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/profil/likes")
@Slf4j
public class LikesController {

    private final LikeRepository lk;
    private final UserRepository userRepository;

    public LikesController(LikeRepository lk, UserRepository userRepository) {
        this.lk = lk;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String showLikesPage(Model model){
        model.addAttribute("political", lk.findAllByCategory("political"));

        return "profil/likes";
    }

    @PostMapping
    public String setLikesPage(Model model, Authentication auth){
        List<Like> likes = (List<Like>) model.getAttribute("political");
        UserDetails currentUser = (UserDetails) auth.getPrincipal();
//        currentUser.
//        TODO pobrać obiekt użytkownika z security

        return "redirect:/profil";
    }
}

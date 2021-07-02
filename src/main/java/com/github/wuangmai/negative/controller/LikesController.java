package com.github.wuangmai.negative.controller;

import com.github.wuangmai.negative.model.Like;
import com.github.wuangmai.negative.model.User;
import com.github.wuangmai.negative.repository.LikeRepository;
import com.github.wuangmai.negative.repository.UserRepository;
import com.sun.xml.bind.v2.TODO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.Transient;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/profil/likes")
@Slf4j
@Transient
public class LikesController {

    private final LikeRepository lk;
    private final UserRepository userRepository;

    public LikesController(LikeRepository lk, UserRepository userRepository) {
        this.lk = lk;
        this.userRepository = userRepository;
    }

    @ModelAttribute("allPoliticalLikes")
    public List<Like> PoliticalLikes() {return lk.findAllByCategory("political");}

    @ModelAttribute("allEarthShapeLikes")
    public List<Like> earthShapeLikes() {return lk.findAllByCategory("earth shape");}

    @ModelAttribute("allVaccinesLikes")
    public List<Like> vaccinesLikes() {return lk.findAllByCategory("vaccines");}

    @ModelAttribute("allLikes")
    public List<Like> allLikes(){return  lk.findAll();}

    @GetMapping
    public String showLikesPage(){
        return "profil/likes";
    }

    @PostMapping
    public String setLikesPage(Principal principal, @RequestParam String political, @RequestParam String earth){
        List<Like> likes = new ArrayList<>();

        likes.add(lk.findLikeByName(political));
        likes.add(lk.findLikeByName(earth));

        String name = principal.getName();

        User addLikes = userRepository.findByName(name);
        addLikes.setLikes(likes);
        userRepository.save(addLikes);

        return "redirect:/profil";
    }
}

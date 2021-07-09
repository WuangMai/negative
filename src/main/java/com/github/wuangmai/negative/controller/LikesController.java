package com.github.wuangmai.negative.controller;

import com.github.wuangmai.negative.model.Like;
import com.github.wuangmai.negative.model.User;
import com.github.wuangmai.negative.repository.LikeRepository;
import com.github.wuangmai.negative.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
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
    public String setLikesPage(Principal principal,
                               @RequestParam String political,
                               @RequestParam String earth,
                               @RequestParam String vaccines){
        List<Like> likes = new ArrayList<>();

        likes.add(lk.findLikeByName(political));
        likes.add(lk.findLikeByName(earth));
        likes.add(lk.findLikeByName(vaccines));

        String name = principal.getName();

        User addLikes = userRepository.findByName(name);
        addLikes.setLikes(likes);
        userRepository.save(addLikes);

        return "redirect:/profil";
    }
}

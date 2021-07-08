package com.github.wuangmai.negative.controller;

import com.github.wuangmai.negative.model.Like;
import com.github.wuangmai.negative.model.User;
import com.github.wuangmai.negative.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/profil/search")
@Slf4j
public class SearchController {
    private final UserRepository ur;

    public SearchController(UserRepository ur) {
        this.ur = ur;
    }

    @GetMapping
    public String showSearchPage(Model model, Principal principal){
        String loggedUsername = principal.getName();
        User byName = ur.findByName(loggedUsername);
        List<Like> byNameLikes = byName.getLikes();
        for (Like like : byNameLikes) {
            log.warn(like.getName() + " " + like.getId());
            log.warn(ur.findMostOppositeLikeId(like.getId()).toString());
        }

        return "profil/search";
    }

}

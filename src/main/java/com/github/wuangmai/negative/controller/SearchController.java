package com.github.wuangmai.negative.controller;

import com.github.wuangmai.negative.model.Like;
import com.github.wuangmai.negative.model.User;
import com.github.wuangmai.negative.repository.LikeRepository;
import com.github.wuangmai.negative.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/search")
@Slf4j
public class SearchController {
    private final UserRepository ur;
    private final LikeRepository lr;

    public SearchController(UserRepository ur, LikeRepository lr) {
        this.ur = ur;
        this.lr = lr;
    }

    @GetMapping()
    public String getSearchPage(@RequestParam String category, Principal principal, Model model){
        User user = ur.findByName(principal.getName());
        Like like = user.getLikes().stream().filter(l -> l.getCategory().equals(category)).collect(Collectors.toList()).get(0);
        if(ur.findMostOppositeLikeId(like.getId()) == null){
//            log.warn(ur.findMostOppositeLikeIdIfNull(like.getId()).toString());
            Like oppositeLike = lr.findById(ur.findMostOppositeLikeIdIfNull(like.getId())).get();
            model.addAttribute("opponent", ur.findFirstUserByLikesContains(oppositeLike));
        }else {
//            log.warn(ur.findMostOppositeLikeId(like.getId()).toString());
            Like oppositeLike = lr.findById(ur.findMostOppositeLikeId(like.getId())).get();
            model.addAttribute("opponent", ur.findFirstUserByLikesContains(oppositeLike));
        }


        return "profil/search";
    }

}

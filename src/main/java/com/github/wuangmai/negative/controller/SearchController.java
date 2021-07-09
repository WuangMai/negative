package com.github.wuangmai.negative.controller;

import com.github.wuangmai.negative.model.Like;
import com.github.wuangmai.negative.model.User;
import com.github.wuangmai.negative.repository.LikeRepository;
import com.github.wuangmai.negative.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.ArrayList;
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
        Like oneUserLike = user.getLikes().stream().filter(l -> l.getCategory().equals(category)).collect(Collectors.toList()).get(0);
        Long oneMostOppositeUserLike = ur.findMostOppositeLikeId(oneUserLike.getId());
        List<User> listOfUsersWithMostOppositeLikes;

        if(oneMostOppositeUserLike == null){
            List<Like> listMostOppositeUserLikesIfNull = lr.findAllById(ur.findMostOppositeLikesIdIfNull(oneUserLike.getId()));
            listOfUsersWithMostOppositeLikes = ur.findAllByLikesIn(listMostOppositeUserLikesIfNull);
        }else {
            List<Like> listMostOppositeUserLikes = lr.findAllById(ur.findMostOppositeLikesId(oneUserLike.getId()));
            listOfUsersWithMostOppositeLikes = ur.findAllByLikesIn(listMostOppositeUserLikes);
        }

        if(listOfUsersWithMostOppositeLikes.size() == 0){
            List<Like> listMostOppositeUserLikesIfNull = lr.findAllById(ur.findMostOppositeLikesIdIfNull(oneUserLike.getId()));
            listOfUsersWithMostOppositeLikes = ur.findAllByLikesIn(listMostOppositeUserLikesIfNull);
        }

        for (User list : listOfUsersWithMostOppositeLikes) {
            if(list.getId() != null){
                model.addAttribute("opponent", list);
                break;
            }
        }

        return "profil/search";
    }

}

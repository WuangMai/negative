package com.github.wuangmai.negative.controller;

import com.github.wuangmai.negative.model.Competition;
import com.github.wuangmai.negative.model.Game;
import com.github.wuangmai.negative.model.Like;
import com.github.wuangmai.negative.model.User;
import com.github.wuangmai.negative.repository.CompetitionRepository;
import com.github.wuangmai.negative.repository.GameRepository;
import com.github.wuangmai.negative.repository.LikeRepository;
import com.github.wuangmai.negative.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/search")
@Slf4j
public class SearchController {
    //TODO CO TO SĄ ZA NAZWY?!?!?!?!
    private final UserRepository ur;
    private final LikeRepository lr;
    private final CompetitionRepository cr;
    private final GameRepository gr;

    public SearchController(UserRepository ur, LikeRepository lr, CompetitionRepository cr, GameRepository gr) {
        this.ur = ur;
        this.lr = lr;
        this.cr = cr;
        this.gr = gr;
    }

    @ModelAttribute
    public List<Competition> competitionList() {
        return cr.findAllByCompetitionNotNull();
    }

    //TODO Zasada: głupi kontroler, mądry serwis, nie odwrotnie (ale tutaj nie ma ... serwisów)
    @GetMapping()
    public String getSearchPage(@RequestParam String category, Principal principal, Model model) {
        //TODO Przykład użycia zapytania, które może być sortowane i limitowane (SQL LIMIT + ORDER BY)
        negatieveRepository.findAllByFirstLikeId(3L, PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "hate")));

        User user = ur.findByName(principal.getName());
        //TODO Zapytanie na bazie zamiast pobierania wszystkiego i męczenia w Javie ;)
        Like oneUserLike = user.getLikes()
                .stream()
                .filter(l -> l.getCategory().equals(category))
                .collect(Collectors.toList()).get(0);
        Long oneMostOppositeUserLike = ur.findMostOppositeLikeId(oneUserLike.getId());
        List<User> listOfUsersWithMostOppositeLikes;

        if (oneMostOppositeUserLike == null) {
            List<Like> listMostOppositeUserLikesIfNull = lr.findAllById(ur.findMostOppositeLikesIdIfNull(oneUserLike.getId()));
            listOfUsersWithMostOppositeLikes = ur.findAllByLikesIn(listMostOppositeUserLikesIfNull);
        } else {
            List<Like> listMostOppositeUserLikes = lr.findAllById(ur.findMostOppositeLikesId(oneUserLike.getId()));
            listOfUsersWithMostOppositeLikes = ur.findAllByLikesIn(listMostOppositeUserLikes);
        }

        if (listOfUsersWithMostOppositeLikes.size() == 0) {
            List<Like> listMostOppositeUserLikesIfNull = lr.findAllById(ur.findMostOppositeLikesIdIfNull(oneUserLike.getId()));
            listOfUsersWithMostOppositeLikes = ur.findAllByLikesIn(listMostOppositeUserLikesIfNull);
        }

        for (User list : listOfUsersWithMostOppositeLikes) {
            if (list.getId() != null) {
                model.addAttribute("opponent", list);
                break;
            }
        }

        return "profil/search";
    }

    @PostMapping
    public String postSearchPage(Principal principal,
                                 @RequestParam String oppName,
                                 @RequestParam Long competition) {
        User opponent = ur.findByName(oppName);
        User user = ur.findByName(principal.getName());
        Competition comp = cr.findById(competition).get();

        Game game = new Game(user, opponent, comp, "true");
        gr.save(game);

        return "profil/game";
    }

}

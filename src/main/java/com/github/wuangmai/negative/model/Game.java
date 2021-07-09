package com.github.wuangmai.negative.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "games")
@Getter @Setter
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @OneToOne
    private User user1;

    @NotBlank
    @OneToOne
    private User user2;

    @NotBlank
    @OneToOne
    private Competition competition;

    private String isActive;

    @OneToOne
    private User winner;

    public Game(User user1, User user2, Competition competition, String isActive) {
        this.user1 = user1;
        this.user2 = user2;
        this.competition = competition;
        this.isActive = isActive;
    }
}

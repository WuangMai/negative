package com.github.wuangmai.negative.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
@Getter @Setter @ToString
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true, length = 50, nullable = false)
    private String name;

    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "integer default 1000 not null")
    private int points;

    @ManyToMany
    @JoinTable(name = "users_likes")
    private List<Like> likes = new ArrayList<>();

    private String role;

}

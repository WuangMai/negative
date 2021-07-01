package com.github.wuangmai.negative.model;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
@Getter @Setter @ToString
@RequiredArgsConstructor
@DynamicUpdate
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_likes",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "like_id"))
    @NotEmpty
    private List<Like> likes = new ArrayList<>();

    private String role;

}

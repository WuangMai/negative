package com.github.wuangmai.negative.model;

import lombok.*;

import javax.persistence.*;

@Entity(name = "likes")
@Getter @Setter
@RequiredArgsConstructor
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

}

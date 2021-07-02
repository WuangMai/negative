package com.github.wuangmai.negative.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter @Getter
@RequiredArgsConstructor
@Table(name = "negatives")
public class Negative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Like firstLikeId;

    @OneToOne
    private Like secondLikeId;

    private double hate;

}

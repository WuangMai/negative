package com.github.wuangmai.negative.repository;

import com.github.wuangmai.negative.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}

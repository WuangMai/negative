package com.github.wuangmai.negative.repository;

import com.github.wuangmai.negative.model.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {

    //TODO To jest niepotrzebne, w repozytoriach jest metoda findAll() już gotowa
    @Query("select competition from competitions")
    List<Competition> findAllCompetitions();
    List<Competition> findAllByCompetitionNotNull();
}

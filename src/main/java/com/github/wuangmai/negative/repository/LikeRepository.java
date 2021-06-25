package com.github.wuangmai.negative.repository;

import com.github.wuangmai.negative.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {

    List<Like> findAllByCategory(String category);
}

package com.github.wuangmai.negative.repository;

import com.github.wuangmai.negative.model.Like;
import com.github.wuangmai.negative.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    User findByName(String name);
//    @Query(value = "select * from users u join users_likes ul on u.id = ul.user_id jo where ul.like_id",nativeQuery = true)
    @Query(value = "select second_like_id_id from negatives where first_like_id_id = ?1 order by hate desc limit 1",nativeQuery = true)
    Long findMostOppositeLikeId(Long likeId);

    @Query(value = "select first_like_id_id from negatives where second_like_id_id = ?1 order by hate desc limit 1",nativeQuery = true)
    Long findMostOppositeLikeIdIfNull(Long likeId);

    User findFirstUserByLikesContains(Like like);
}

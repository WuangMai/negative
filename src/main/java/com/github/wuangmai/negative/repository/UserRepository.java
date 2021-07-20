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

    //TODO Te zapytania dotyczą encji Negative i powinny być w NegativeRepository
    //TODO Użyć Pageable zamiast nativeQuery
    /*
        List<Negative> findAllByFirstLikeId(Long id, Pageable page)

        // W kontrolerze:

     */
    @Query(value = "select second_like_id_id from negatives where first_like_id_id = ?1 order by hate desc limit 1",nativeQuery = true)
    Long findMostOppositeLikeId(Long likeId);

    @Query(value = "select second_like_id_id from negatives where first_like_id_id = ?1 order by hate desc limit 5",nativeQuery = true)
    List<Long> findMostOppositeLikesId(Long likeId);

    @Query(value = "select first_like_id_id from negatives where second_like_id_id = ?1 order by hate desc limit 1",nativeQuery = true)
    Long findMostOppositeLikeIdIfNull(Long likeId);

    @Query(value = "select first_like_id_id from negatives where second_like_id_id = ?1 order by hate desc limit 5",nativeQuery = true)
    List<Long> findMostOppositeLikesIdIfNull(Long likeId);

    User findFirstUserByLikesContains(Like like);

    List<User> findAllByLikesIn(List<Like> likes);
}

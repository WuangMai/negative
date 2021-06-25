package com.github.wuangmai.negative.repository;

import com.github.wuangmai.negative.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

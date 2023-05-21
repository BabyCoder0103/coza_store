package com.cybersoft.cozastore.repository;

import com.cybersoft.cozastore.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepositoty extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findByUsernameAndPassword(String username, String password);
}

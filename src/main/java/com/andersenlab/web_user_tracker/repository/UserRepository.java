package com.andersenlab.web_user_tracker.repository;

import com.andersenlab.web_user_tracker.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends CrudRepository <UserEntity, Long>{
    boolean existsByLogin(String login);
    Optional<UserEntity> findByNick(String login);
}

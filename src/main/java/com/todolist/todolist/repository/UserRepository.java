package com.todolist.todolist.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.todolist.todolist.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
    Optional<UserEntity> findByUsername(String username);
    

}

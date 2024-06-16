package com.todolist.todolist.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.todolist.todolist.entity.RolEntity;

public interface RolRepository extends CrudRepository<RolEntity,Long>{

    Optional<RolEntity> findByRolName(String rolName);

    

}

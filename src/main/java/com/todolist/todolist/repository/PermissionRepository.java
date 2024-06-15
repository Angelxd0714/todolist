package com.todolist.todolist.repository;

import org.springframework.data.repository.CrudRepository;

import com.todolist.todolist.entity.PermissionsEntity;

public interface PermissionRepository extends CrudRepository<PermissionsEntity,Long> {
    
}

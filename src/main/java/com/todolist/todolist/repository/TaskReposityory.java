package com.todolist.todolist.repository;

import org.springframework.data.repository.CrudRepository;

import com.todolist.todolist.entity.TaskEntity;

import java.util.Optional;

public interface TaskReposityory extends CrudRepository<TaskEntity, Long> {
    Optional<TaskEntity> findById(Long taskId);
}

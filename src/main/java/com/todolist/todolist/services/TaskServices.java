package com.todolist.todolist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.todolist.entity.TaskEntity;

import com.todolist.todolist.repository.TaskReposityory;

import java.util.List;

@Service
public class TaskServices {

    @Autowired
    private TaskReposityory taskReposityory;

    public List<TaskEntity> findAll() {
        return (List<TaskEntity>) taskReposityory.findAll();
    }

    public TaskEntity save(TaskEntity taskEntity) {
        return taskReposityory.save(taskEntity);
    }

    public void deleteById(Long id) {
        taskReposityory.deleteById(id);
    }

    public TaskEntity findById(Long id) {
        return taskReposityory.findById(id).get();
    }

    public TaskEntity update(TaskEntity taskEntity, long id) {
        TaskEntity existTask = taskReposityory.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
                
        existTask.setTitle(existTask.getTitle());
        existTask.setDescription(existTask.getDescription());
        existTask.setStatus(existTask.getStatus());
        existTask.setCreatedAt(existTask.getCreatedAt());
        existTask.setUpdatedAt(existTask.getUpdatedAt());
        return taskReposityory.save(existTask);

    }

}

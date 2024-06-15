package com.todolist.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.todolist.todolist.entity.TaskEntity;

import com.todolist.todolist.services.TaskServices;

@RestController
@RequestMapping("/tasks/")
public class TaskController {
    @Autowired
    private TaskServices taskService;

    @GetMapping
    public List<TaskEntity> getAllTask() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable Long id) {
        TaskEntity task = taskService.findById(id);
        return ResponseEntity.ok(task);
    }

    @PostMapping
    public TaskEntity createTask(@RequestBody TaskEntity task) {
        return taskService.save(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskEntity> updateTask(@RequestBody TaskEntity task, @PathVariable long id) {
        TaskEntity updatedTask = taskService.update(task, id);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

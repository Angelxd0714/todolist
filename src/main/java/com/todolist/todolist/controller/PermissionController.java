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

import com.todolist.todolist.entity.PermissionsEntity;
import com.todolist.todolist.services.PermissionServices;

@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionServices permissionServices;

    @GetMapping("/all")
    public ResponseEntity<PermissionsEntity> getAllPermission() {
        PermissionsEntity allPermission = (PermissionsEntity) permissionServices.getAllPermissions();
        return ResponseEntity.ok(allPermission);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissionsEntity> getPermissionById(@PathVariable Long id) {
        PermissionsEntity permission = permissionServices.getPermissionById(id);
        return ResponseEntity.ok(permission);
    }

    @GetMapping("/{name}")
    public ResponseEntity<PermissionsEntity> getPermissionByName(@PathVariable String name) {
        PermissionsEntity permission = permissionServices.getPermissionByName(name);
        return ResponseEntity.ok(permission);
    }

    @PostMapping("/create")
    public ResponseEntity<PermissionsEntity> createPermission(@RequestBody PermissionsEntity permission) {
        PermissionsEntity createdPermission = permissionServices.createPermission(permission);
        return ResponseEntity.ok(createdPermission);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermissionsEntity> updatePermission(@RequestBody PermissionsEntity permission,
            @PathVariable long id) {
        PermissionsEntity updatedPermission = permissionServices.updatePermission(permission, id);
        return ResponseEntity.ok(updatedPermission);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PermissionsEntity> deletePermission(@PathVariable long id) {
        permissionServices.deletePermission(id);
        return ResponseEntity.noContent().build();
    }
}

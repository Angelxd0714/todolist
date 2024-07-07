package com.todolist.todolist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.todolist.entity.PermissionsEntity;
import com.todolist.todolist.repository.PermissionRepository;

@Service
public class PermissionServices {
    @Autowired
    private PermissionRepository permissionRepository;

    public PermissionServices(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public PermissionsEntity createPermission(PermissionsEntity permission) {
        return permissionRepository.save(permission);
    }

    public void deletePermission(Long id) {
        PermissionsEntity permission = permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found"));
        permissionRepository.delete(permission);
    }

    public PermissionsEntity getPermissionById(Long id) {
        return permissionRepository.findById(id).orElseThrow(() -> new RuntimeException("Permission not found"));
    }

    public Iterable<PermissionsEntity> getAllPermissions() {
        return permissionRepository.findAll();

    }

    public PermissionsEntity updatePermission(PermissionsEntity permission, Long id) {
        PermissionsEntity existPermission = permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found"));
        existPermission.setName(permission.getName());
        return permissionRepository.save(existPermission);
    }

    public PermissionsEntity getPermissionByName(String name) {
        PermissionsEntity permission = permissionRepository.findByName(name);
        if (permission == null) {
            throw new RuntimeException("Permission not found");
        }
        return permission;
    }
}

package com.todolist.todolist.entity;

import java.util.Set;

import com.todolist.todolist.models.RolesEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.JoinColumn;



@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rol")
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "roles_name", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private RolesEnum rolName;
    @Column(name = "description", nullable = true, length = 100)
    private String description;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles_permissions", joinColumns = @JoinColumn(name = "permission_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<PermissionsEntity> permissions;

}

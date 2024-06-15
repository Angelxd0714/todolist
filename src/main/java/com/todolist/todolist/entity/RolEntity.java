package com.todolist.todolist.entity;

import java.util.Set;

import com.todolist.todolist.models.RolesEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



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
    @Column(name = "description", nullable = false, length = 100)
    @ManyToMany(mappedBy = "rol")
    private Set<UserEntity> users;
    @ManyToMany(mappedBy = "roles")
    private Set<PermissionsEntity> permissions;

}

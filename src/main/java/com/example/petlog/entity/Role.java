package com.example.petlog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private @Getter @Setter Integer roleId;

    @Column(name = "role_name")
    private @Getter @Setter String roleName;

    @ManyToMany(mappedBy = "roles")
    private @Getter @Setter Collection<User> users;

}

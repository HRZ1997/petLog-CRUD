package com.example.petlog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @Column(name = "id")
    private @Getter @Setter String id;

    @Column(name = "user_name")
    private @Getter @Setter String userName;

    @Column(name = "first_name")
    private @Getter @Setter String firstName;

    @Column(name = "last_name")
    private @Getter @Setter String lastName;

    @Column(name = "email")
    private @Getter @Setter String email;

    @Column(name = "phone")
    private @Getter @Setter String phone;

}

package com.example.petlog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @Column(name = "user_id")
    private @Getter @Setter String id;

    @Column(name = "user_name")
    private @Getter @Setter String username;

    @Column(name = "password")
    private @Getter @Setter String password;

    @Column(name = "first_name")
    private @Getter @Setter String firstName;

    @Column(name = "last_name")
    private @Getter @Setter String lastName;

    @Column(name = "email")
    private @Getter @Setter String email;

    @Column(name = "phone")
    private @Getter @Setter String phone;

    @Column(name = "birthday")
    private @Getter @Setter Date birthday;

}

package com.example.petlog.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "userInfos")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserInfo {

    @Id
    @Column(name = "user_id")
    private @Getter @Setter Long userId;

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

    @OneToOne(mappedBy = "userInfo")
    @JsonManagedReference
    private @Getter @Setter User user;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private @Getter @Setter Collection<Pet> pets;

    @OneToMany(mappedBy = "userInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private @Getter @Setter Collection<Log> logs;

}

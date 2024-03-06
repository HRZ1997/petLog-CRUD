package com.example.petlog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "userInfos")
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "user_id_fk")
    private @Getter @Setter User user;

    @OneToMany(mappedBy = "owner",
            cascade = CascadeType.ALL)
    private @Getter @Setter Collection<Pet> pets;

    @OneToMany(mappedBy = "userInfo",
    cascade = CascadeType.ALL)
    private @Getter @Setter List<Log> logs;


    public UserInfo(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}

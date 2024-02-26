package com.example.petlog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "pets")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pet {

    @Id
    @Column(name = "pet_id")
    private @Getter @Setter String pet_id;

    @Column(name = "name")
    private @Getter @Setter String name;

    @Column(name = "breed")
    private @Getter @Setter String breed;

    @Column(name = "dob")
    private @Getter @Setter String dateOfBirth;

    @Column(name = "owner_id")
    private @Getter @Setter UUID owner_id;

}
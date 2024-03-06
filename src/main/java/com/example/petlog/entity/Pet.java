package com.example.petlog.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "pets")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pet {

    @Id
    @Column(name = "pet_id")
    private @Getter @Setter Long petId;

    @Column(name = "name")
    private @Getter @Setter String name;

    @Column(name = "dob")
    private @Getter @Setter Date dateOfBirth;

    @Column(name = "breed_id")
    private @Getter @Setter Integer breedId;

    @Column(name = "owner_id")
    private @Getter @Setter Long ownerId;

    public Pet(String name, Date dateOfBirth, Integer breedId, Long ownerId) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.breedId = breedId;
        this.ownerId = ownerId;
    }
}
package com.example.petlog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "pets")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pet {

    @Id
    @Column(name = "pet_id")
    private @Getter @Setter String petId;

    @Column(name = "name")
    private @Getter @Setter String name;

    @Column(name = "breed_id")
    private @Getter @Setter String breedId;

    @Column(name = "dob")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private @Getter @Setter Date dateOfBirth;

    @Column(name = "owner_id")
    private @Getter @Setter String ownerId;

}
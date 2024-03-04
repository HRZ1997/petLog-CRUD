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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "breed_id")
    private @Getter @Setter Breed breed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    @JsonBackReference
    private @Getter @Setter UserInfo owner;

    @ManyToMany(mappedBy = "pets")
    private @Getter @Setter Collection<Log> logs;

}
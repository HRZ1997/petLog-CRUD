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
public class Pet {

    @Id
    @Column(name = "pet_id")
    private @Getter @Setter Long petId;

    @Column(name = "name")
    private @Getter @Setter String name;

    @Column(name = "dob")
    private @Getter @Setter Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserInfo owner;

    @ManyToOne
    @JoinColumn(name = "breed_id")
    private @Getter @Setter Breed breed;

    @ManyToMany(mappedBy = "pets")
    private @Getter @Setter Collection<Log> logs;

    public Pet(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
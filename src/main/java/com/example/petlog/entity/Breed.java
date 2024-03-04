package com.example.petlog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Table(name = "breeds")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Breed {

    @Id
    @Column(name = "breed_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Integer breedId;

    @Column(name = "breed_name")
    private @Getter @Setter String breedName;

    @OneToMany(mappedBy = "breed")
    private @Getter @Setter Collection<Pet> pets;

}

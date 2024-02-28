package com.example.petlog.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "breeds")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Breed {

    @Id
    @Column(name = "breed_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter int breedId;

    @Column(name = "breed_name")
    private @Getter @Setter String breedName;

}

package com.example.petlog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Table(name = "breeds")
@NoArgsConstructor
@AllArgsConstructor
public class Breed {

    @Id
    @Column(name = "breed_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Integer breedId;

    @Column(name = "breed_name")
    private @Getter @Setter String breedName;

    @OneToMany(mappedBy = "breed", cascade = CascadeType.ALL)
    private Collection<Pet> pets;

    public Breed(Integer breedId, String breedName) {
        this.breedId = breedId;
        this.breedName = breedName;
    }

    @Override
    public String toString() {
        return "Breed{" +
                "breedId=" + breedId +
                ", breedName='" + breedName + '\'' +
                '}';
    }

}

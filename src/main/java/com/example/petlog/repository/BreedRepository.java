package com.example.petlog.repository;

import com.example.petlog.entity.Breed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreedRepository extends JpaRepository<Breed, Integer> {

    Breed getBreedByBreedName(String breedName);

}

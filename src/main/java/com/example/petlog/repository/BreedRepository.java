package com.example.petlog.repository;

import com.example.petlog.entity.Breed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BreedRepository extends JpaRepository<Breed, Integer> {
    @Query("select b from breeds b where b.breed_name = ?1")
    Breed findByBreed(String breed_name);
}

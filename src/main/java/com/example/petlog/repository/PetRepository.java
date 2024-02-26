package com.example.petlog.repository;

import com.example.petlog.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, String> {
}

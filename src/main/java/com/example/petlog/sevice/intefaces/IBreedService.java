package com.example.petlog.sevice.intefaces;

import com.example.petlog.entity.Breed;

import java.util.List;

public interface IBreedService {

    Breed save(Breed theBreed);

    List<Breed> findAll();

    Breed findById(int theId);

    void deleteById(int theId);
}

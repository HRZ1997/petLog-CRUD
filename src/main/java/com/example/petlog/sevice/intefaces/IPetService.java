package com.example.petlog.sevice.intefaces;

import com.example.petlog.entity.Pet;

import java.util.List;

public interface IPetService {
    Pet save(Pet thePet);

    List<Pet> findAll();

    Pet findById(Long theId);

    void deleteById(Long theId);
}

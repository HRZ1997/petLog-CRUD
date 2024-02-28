package com.example.petlog.sevice;

import com.example.petlog.entity.Pet;
import com.example.petlog.entity.User;

import java.util.List;

public interface IPetService {
    Pet save(Pet thePet);

    List<Pet> findAll();

    Pet findById(String theId);

    void deleteById(String theId);
}

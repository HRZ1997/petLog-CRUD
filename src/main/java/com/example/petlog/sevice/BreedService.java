package com.example.petlog.sevice;

import com.example.petlog.entity.Breed;
import com.example.petlog.sevice.intefaces.IBreedService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreedService implements IBreedService {
    @Override
    public Breed save(Breed theBreed) {
        return null;
    }

    @Override
    public List<Breed> findAll() {
        return null;
    }

    @Override
    public Breed findById(int theId) {
        return null;
    }

    @Override
    public void deleteById(int theId) {

    }
}

package com.example.petlog.sevice;

import com.example.petlog.entity.Pet;
import com.example.petlog.repository.PetRepository;
import com.example.petlog.sevice.intefaces.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService implements IPetService {

    private PetRepository petRepository;
    @Autowired
    public PetService(PetRepository thePetRepository) { this.petRepository = thePetRepository; }

    @Override
    public Pet save(Pet thePet) {

        return petRepository.save(thePet);
    }

    @Override
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    @Override
    public Pet findById(Long theId) {
        Optional<Pet> result = petRepository.findById(theId);

        Pet thePet = null;

        if (result.isPresent()) {
            thePet = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return thePet;
    }
    @Override
    public void deleteById(Long theId) {

        petRepository.deleteById(theId);

    }


}

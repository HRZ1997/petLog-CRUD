package com.example.petlog.rest;

import com.example.petlog.entity.Pet;
import com.example.petlog.sevice.PetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class PetController {
    private PetServiceImpl petService;

    @Autowired
    public PetController(PetServiceImpl thePetService) { this.petService = thePetService; }

    @PostMapping("/pet")
    public Pet addPet(@RequestBody Pet thePet) {

        thePet.setPetId(UUID.randomUUID().toString());

        Pet dbPet = petService.save(thePet);

        return dbPet;

    }

    @GetMapping("/pets")
    public List<Pet> findAll() {
        return petService.findAll();
    }

    @GetMapping("/pets/{petId}")
    public Pet getPet(@PathVariable String petId) {

        Pet thePet = petService.findById(petId);

        if (thePet == null) {
            throw new RuntimeException("Pet id not found - " + petId);
        }

        return thePet;
    }

    @PutMapping("/pets")
    public Pet updatePet(@RequestBody Pet thePet) {

        Pet dbPet = petService.save(thePet);

        return dbPet;
    }

    // add mapping for DELETE /pets/{petId} - delete pet

    @DeleteMapping("/pets/{petId}")
    public String deletePet(@PathVariable String petId) {

        Pet tempPet = petService.findById(petId);

        // throw exception if null

        if (tempPet == null) {
            throw new RuntimeException("Pet id not found - " + petId);
        }

        petService.deleteById(petId);

        return "Deleted pet id - " + petId;
    }

}

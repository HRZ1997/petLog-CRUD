package com.example.petlog.interfaces.restController;

import com.example.petlog.entity.Pet;
import com.example.petlog.sevice.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PetController {
    private PetService petService;

    @Autowired
    public PetController(PetService thePetService) { this.petService = thePetService; }

    @PostMapping("/pet")
    public Pet addPet(@RequestBody Pet thePet) {


        Pet dbPet = petService.save(thePet);

        return dbPet;

    }

    @GetMapping("/pets")
    public List<Pet> findAll() {
        return petService.findAll();
    }

    @GetMapping("/pets/{petId}")
    public Pet getPet(@PathVariable Long petId) {

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
    public String deletePet(@PathVariable Long petId) {

        Pet tempPet = petService.findById(petId);

        // throw exception if null

        if (tempPet == null) {
            throw new RuntimeException("Pet id not found - " + petId);
        }

        petService.deleteById(petId);

        return "Deleted pet id - " + petId;
    }

}

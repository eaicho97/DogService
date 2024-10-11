package com.object.dog.controller;

import com.object.dog.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.DogService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dogs")
public class DogController {

    @Autowired
    private DogService dogService;

    @PostMapping
    public ResponseEntity<Dog> createDog(@RequestBody Dog dog){
        return new ResponseEntity<>(dogService.saveNameDog(dog), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Dog> getAllDogs(){
        return dogService.getAllNames();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> getDogById(@PathVariable Long id){
        return dogService.getDogById(id)
                .map(dogName -> new ResponseEntity<>(dogName, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dog> updateDog(@PathVariable Long id, @RequestBody Dog updateDog){
        return dogService.getDogById(id).map(existingDog -> {
            existingDog.setName((updateDog.getName()));
            existingDog.setBreed(updateDog.getBreed());
            existingDog.setOwnerPhone(updateDog.getOwnerPhone());
            return new ResponseEntity<>(dogService.saveNameDog(existingDog), HttpStatus.OK);
        })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDog(@PathVariable Long id){
        dogService.deleteName(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package com.object.dog.service;

import com.object.dog.model.Dog;
import com.object.dog.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogService {

    @Autowired
    private DogRepository dogRepository;

    public Dog saveNameDog(Dog dogName){
        return dogRepository.save(dogName);
    }

    public List<Dog> getAllNames(){
        return dogRepository.findAll();
    }

    public Optional<Dog> getDogById(Long id){
        return dogRepository.findById(id);
    }

    public void deleteName(Long id){
        dogRepository.deleteById(id);
    }
}

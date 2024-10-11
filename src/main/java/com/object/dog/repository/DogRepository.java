package com.object.dog.repository;

import com.object.dog.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Long>{
}

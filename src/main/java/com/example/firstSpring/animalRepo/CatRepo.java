package com.example.firstSpring.animalRepo;

import com.example.firstSpring.animalEntity.Cats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepo extends JpaRepository<Cats, Integer>  {

}

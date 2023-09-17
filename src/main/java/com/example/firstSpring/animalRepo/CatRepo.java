package com.example.firstSpring.animalRepo;

import com.example.firstSpring.animalEntity.Cats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



public interface CatRepo extends JpaRepository<Cats, Integer>  {

}

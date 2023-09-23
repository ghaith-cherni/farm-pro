package com.example.firstSpring.animalRepo;

import com.example.firstSpring.animalEntity.Cats;
import com.example.firstSpring.response.ResponseCats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CatRepo extends JpaRepository<Cats, Integer>  {
    List<Cats> findByName(String name) ;


    List<Cats> findCatsByName(String name);

}

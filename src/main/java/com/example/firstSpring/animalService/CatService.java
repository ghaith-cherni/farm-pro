package com.example.firstSpring.animalService;

import com.example.firstSpring.animalEntity.Cats;
import com.example.firstSpring.animalRepo.CatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatService {
    @Autowired
    CatRepo catRepo;


    public List<Cats> getAllCats() {
        List<Cats> target = new ArrayList<>();
        catRepo.findAll().forEach(target::add);
        return target;

    }
//        public Cats   getCatWithId(int id) {
//
//            return catRepo.getById(id);
//    }
}


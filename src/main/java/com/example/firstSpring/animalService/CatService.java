package com.example.firstSpring.animalService;
import com.example.firstSpring.animalEntity.Cats;
import com.example.firstSpring.animalRepo.CatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
    public class CatService {

        private final CatRepo catRepo;

        @Autowired
        public CatService (CatRepo catRepo) {
            this.catRepo = catRepo;
        }

        public List<Cats> getAllCats() {
            return  catRepo.findAll()  ;

        }
        public Cats   getCatWithId(int id) {

            return catRepo.getById(id);
    }
    }


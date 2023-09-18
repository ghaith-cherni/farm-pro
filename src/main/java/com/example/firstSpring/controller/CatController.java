package com.example.firstSpring.controller;

import com.example.firstSpring.animalEntity.Cats;
import com.example.firstSpring.animalService.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/db")
public class CatController {
    @Autowired
    CatService catService;


    @GetMapping("/cats")
    public ResponseEntity<List<Cats>> getAllCats() {
        List<Cats> cats = catService.getAllCats();
        return ResponseEntity.ok(cats);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cats> getCatById(@PathVariable int id) {
        Cats  catWithId = catService.getCatWithId(id);
        if(catWithId != null) {
            return ResponseEntity.ok(catWithId);
        }return ResponseEntity.notFound().build();
    }
}








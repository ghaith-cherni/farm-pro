package com.example.firstSpring.controller;

import com.example.firstSpring.animalEntity.Cats;
import com.example.firstSpring.animalService.CatService;
import com.example.firstSpring.request.CheckCatReq;
import com.example.firstSpring.response.ResponseCats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        Cats catWithId = catService.getCatWithId(id);
        if (catWithId != null) {
            return ResponseEntity.ok(catWithId);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/cats")
    public ResponseEntity<Cats> createCat(@RequestBody Cats newCat) {

        Cats cat = catService.createCat(newCat);

        return ResponseEntity.status(HttpStatus.CREATED).body(cat);
    }

    @PostMapping("/check-cat")
    public ResponseEntity<String> checkCat(@RequestBody CheckCatReq checkCatReq) {
        if (catService.findCat(checkCatReq) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("found");
        }
    }

    @PostMapping("/getCatByName")
    public ResponseEntity<ResponseCats> checkExistingCat(@RequestBody CheckCatReq checkCatReq ) {
            ResponseCats resCat = catService.findCatByName(checkCatReq);

        if (resCat == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(resCat);
        }
    }

}





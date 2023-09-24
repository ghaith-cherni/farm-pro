package com.example.firstSpring.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.firstSpring.animalEntity.Cats;
import com.example.firstSpring.animalService.CatService;
import com.example.firstSpring.request.CheckCatReq;
import com.example.firstSpring.response.ResponseCats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
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





//TODO :  create  react app , list all cats , create cats form in a separate page        : 2 screens
// TODO :every cat has it's owner (name, surname , birthdate and possess only one cat and has a profile pic),
//  make  page   with users list with data above name ... cat , when cat is clicked it render an other page  ( cat data : name id price ...),
//  third page : sign in as a user  : fullName , profile pic

//TODO
// package owner entity -> owner /package owner-repo -> interface ownerRepo   /package owner-service ->ownerService  /package owner-controller ->ownerController,
// ,add  to table cat a owner column in postgresSql, table owner
// add to the cat entity owner attribute, repo,service,controller
// , Get request /db/Get-owners
/* [{ "name": String,
    "surname":String,
    "age":int,
    "animalName":String
    "animalId"
    },
    ]
    ,table owner :  id
                    name
                    surname
                    birthday
                    profilePic : Sting url
                    animal id


//TODO*   Get request /db/Get-animal/{id}







*/
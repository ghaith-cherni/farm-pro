package com.example.firstSpring.controller.ownerController;


import com.example.firstSpring.animalEntity.Cats;
import com.example.firstSpring.ownerEntity.Owner;
import com.example.firstSpring.ownerService.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/db")
public class OwnerController {

    @Autowired
    public OwnerService ownerService;
@GetMapping("/owner")
    public ResponseEntity<List<Owner>> getAllOwners() {
        List<Owner>owners=OwnerService.getOwners();
        return ResponseEntity.ok(owners);
    }


}















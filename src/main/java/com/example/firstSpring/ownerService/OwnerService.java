package com.example.firstSpring.ownerService;

import com.example.firstSpring.animalEntity.Cats;
import com.example.firstSpring.animalRepo.CatRepo;
import com.example.firstSpring.ownerEntity.Owner;
import com.example.firstSpring.ownerRepo.OwnerRepo;
import com.example.firstSpring.response.OwnerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class OwnerService {
    @Autowired
    OwnerRepo ownerRepo;
    @Autowired
    public CatRepo catRepo;

    public List<OwnerResponse> getOwners() {
        List<OwnerResponse> ownerResponses = new ArrayList<>();
        List<Owner> res = ownerRepo.findAll();

        for (Owner o : res) {
            Cats cat = o.getCats();
            String animalName = cat.getName();
            int animalId = cat.getId();

            LocalDate birthday = o.getBirthday();

            OwnerResponse or = new OwnerResponse(o.getName(), o.getLastname(), age, animalName, animalId);
            ownerResponses.add(or);

        }
        return ownerResponses;
    }

    public Owner addOwner(Owner owner) {
        List<Owner> existingOwner = ownerRepo.findByUsername(owner.getUsername());
        if (!existingOwner.isEmpty()) {
            return null;
        } else {
            ownerRepo.save(owner);
            return owner;
        }
    }
//    public Owner buyAnimal(Owner owner, Cats cat){
//
//    }

}

        if (birthday != null) {
                Period agePeriod = Period.between(birthday, currentDate);
                int age = agePeriod.getYears();

                OwnerResponse or = new OwnerResponse(o.getName(), o.getLastname(), catName, catId, age);
                ownerResponses.add(or);
                } else {
                // Handle cases where the birthday is not available
                OwnerResponse or = new OwnerResponse(o.getName(), o.getLastname(), catName, catId, 0); // Default age 0
                ownerResponses.add(or);
                }





/*

             if (cat == null) {
                return null;
            } else {


  */
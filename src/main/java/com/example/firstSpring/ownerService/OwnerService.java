package com.example.firstSpring.ownerService;

import com.example.firstSpring.animalRepo.CatRepo;
import com.example.firstSpring.ownerEntity.Owner;
import com.example.firstSpring.ownerRepo.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OwnerService {
    @Autowired
    OwnerRepo ownerRepo;
    @Autowired
    public CatRepo catRepo;

    public List<Owner> getOwners() {
        List<Owner> owners = new ArrayList<>();
        ownerRepo.findAll().forEach(owners::add);
        return owners;
    }

    public Owner addOwner(Owner owner) {
        List<Owner> existingOwner=ownerRepo.findByUsername(owner.getUsername());
        if(!existingOwner.isEmpty()){
            return null;
        } else {
            ownerRepo.save(owner);
            return owner ;
        }
    }
//    public Owner buyAnimal(Owner owner){
//
//    }

}

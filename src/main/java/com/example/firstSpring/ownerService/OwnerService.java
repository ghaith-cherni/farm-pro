package com.example.firstSpring.ownerService;

import com.example.firstSpring.animalEntity.Cats;
import com.example.firstSpring.animalRepo.CatRepo;
import com.example.firstSpring.ownerEntity.Owner;
import com.example.firstSpring.ownerRepo.OwnerRepo;
import com.example.firstSpring.request.Animal2Owner;
import com.example.firstSpring.response.OwnerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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

            LocalDate birthday = o.getBirthday();
            if (birthday != null) {
                LocalDate currentDate = LocalDate.now();
                Period agePeriod = Period.between(birthday, currentDate);
                int age = agePeriod.getYears();
                if (cat != null) {

                    String animalName = cat.getName();
                    int animalId = cat.getId();

                    OwnerResponse or = new OwnerResponse(o.getName(), o.getLastname(), age, animalName, animalId);
                    ownerResponses.add(or);
                } else {
                    OwnerResponse or = new OwnerResponse(o.getName(), o.getLastname(), age, "no animal found", 0);
                    ownerResponses.add(or);
                }
            } else if (cat != null) {
                String animalName = cat.getName();
                int animalId = cat.getId();
                OwnerResponse or = new OwnerResponse(o.getName(), o.getLastname(), 0, animalName, animalId);
                ownerResponses.add(or);
            } else {
                OwnerResponse or = new OwnerResponse(o.getName(), o.getLastname(), 0, "no animal found", 0);
                ownerResponses.add(or);
            }
        }
        return ownerResponses;
    }


    public Owner addOwner(Owner owner) {
        List<Owner> existingOwnerName = ownerRepo.findByUsername(owner.getUsername());
        Optional<Owner> existingOwnerId = ownerRepo.findById(owner.getId());
        if (!existingOwnerName.isEmpty() || existingOwnerId.isPresent()) {
            return null;
        } else {
            ownerRepo.save(owner);
            return owner;
        }
    }
 //   [
//     {      cat_id: catId,
//            owner_id: ownersList.find((owner) => owner.name === newOwnerName)?.id || '',
//            operation: 'update' },
//
        //    cat_id: catId,
        //    owner_id: '', // No owner
        //    operation: 'delete',
        //    ]
    public List<Owner> updateOwners(List<Animal2Owner> references) {
        List<Owner> ownerResponses = new ArrayList<>();

        for (Animal2Owner o : references) {
            System.out.println(o.getOwner_id());
            List<Owner> owners4Update = ownerRepo.findByCats_Id(o.getCat_id());
            String operation = o.getOperation();
            for (Owner u : owners4Update) {

                if (operation == "update") {

                    Owner owner2Update = new Owner(o.getOwner_id(), u.getName(), u.getLastname(), u.getBirthday(),
                            u.getProfilepic(), u.getUsername(), u.getPassword(), catRepo.findCatsById(o.getCat_id()));

                    System.out.println(o.getOwner_id());
                    System.out.println(u.getId());

                    ownerResponses.add(owner2Update);
                    ownerRepo.save(owner2Update);

                } else if (operation == "delete") {
                    Cats cat = new Cats(0, "", 0);
                    Owner owner2Update = new Owner(u.getId(), u.getName(), u.getLastname(), u.getBirthday(),
                            u.getProfilepic(), u.getUsername(), u.getPassword(), cat);
                    ownerResponses.add(owner2Update);
                    ownerRepo.save(owner2Update);
                }
            }
        }
        return ownerResponses;

    }


}







/*
for (Owner o : res) {
    Cats cat = o.getCats();
    LocalDate birthday = o.getBirthday();
    OwnerResponse or = new OwnerResponse(o.getName(), o.getLastname(), 0, "no animal found", 0);

    if (birthday != null) {
        LocalDate currentDate = LocalDate.now();
        Period agePeriod = Period.between(birthday, currentDate);
        int age = agePeriod.getYears();
        or.setAge(age);

        if (cat != null) {
            or.setAnimalName(cat.getName());
            or.setAnimalId(cat.getId());
        }
    } else if (cat != null) {
        or.setAnimalName(cat.getName());
        or.setAnimalId(cat.getId());
    }

    ownerResponses.add(or);
}
return ownerResponses;

  */
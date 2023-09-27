package com.example.firstSpring.controller.ownerController;
import com.example.firstSpring.animalEntity.Cats;
import com.example.firstSpring.ownerEntity.Owner;
import com.example.firstSpring.ownerService.OwnerService;
import com.example.firstSpring.request.OwnerRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/db")
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @GetMapping("/owner")
    public ResponseEntity<List<Owner>> getAllOwners() {
        List<Owner> owners = ownerService.getOwners();
        return ResponseEntity.ok(owners);
    }

    @PostMapping("create-owner")
    public ResponseEntity<Owner> creatOwner(@RequestBody OwnerRequest newOwner) {
        LocalDate newBirthday = LocalDate.parse(newOwner.getBirthday());
        Owner convertedNewOwner = new Owner(newOwner.getId(), newOwner.getName(), newOwner.getLastname(),
                newBirthday, newOwner.getProfilepic(), newOwner.getUsername(), newOwner.getPassword(), new Cats());
        Owner owner = ownerService.addOwner(convertedNewOwner);
        if (ownerService.addOwner(convertedNewOwner) == null) {
            return null;
            // return ResponseEntity.status(HttpStatus.CONFLICT).ErrorResponse;
        }
        return ResponseEntity.status(HttpStatus.OK).body(owner);
    }
//    @PostMapping("animal-purchase")
//    public ResponseEntity<Owner> purchase(@RequestBody OwnerRequest newOwner) {
//
//    }
}















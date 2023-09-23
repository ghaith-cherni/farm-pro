package com.example.firstSpring.ownerEntity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "owners")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Owner {
    @Id
    int id;
    String name;
    String lastname;
    LocalDate birthday;
    String profilepic;
    String username;
   String password;
//   int posAnimalId;
}

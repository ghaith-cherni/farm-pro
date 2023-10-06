package com.example.firstSpring.request;

import com.example.firstSpring.animalEntity.Cats;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OwnerRequest {
    int id;
    String name;
    String lastname;
    String birthday;
    String profilepic;
    String username;
    String password;
    // Cats  cats;
}

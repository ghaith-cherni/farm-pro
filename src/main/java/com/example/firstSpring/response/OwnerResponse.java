package com.example.firstSpring.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerResponse {
    String name ;
    String lastname ;
    int age;
    String animalName;
    int animalId ;

}

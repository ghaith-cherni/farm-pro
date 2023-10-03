package com.example.firstSpring.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal2Owner {
     int  cat_id ;
     int owner_id;
     String operation;
}

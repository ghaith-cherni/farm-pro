package com.example.firstSpring.animalEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cats")
@Data
@NoArgsConstructor
public class Cats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price;
    public Cats (int id , String name ,int price)  {
            this.id = id;
             this.name = name;
              this.price = price;
    }

}


package com.example.firstSpring.animalEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

// TODO : implementation recherche  by cat id ,  create new cat ( post) ,         done
//  create  react app , list all cats , create cats form in a separate page
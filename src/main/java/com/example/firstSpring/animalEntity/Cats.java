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
    protected Cats (int id , String name ,int price)  {
            this.id = id;
             this.name = name;
             this.price = price;
    }
    public int getId() {return id;}
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setPrice(int price) {this.price = price;}
}


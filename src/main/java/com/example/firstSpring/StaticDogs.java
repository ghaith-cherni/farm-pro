package com.example.firstSpring;

public class StaticDogs extends Animal {
    public StaticDogs(int id, String name, int price) {
        super(id, name, price);
    }
    public int getId() {return id; }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
}

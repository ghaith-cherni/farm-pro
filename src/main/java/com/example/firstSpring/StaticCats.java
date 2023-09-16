package com.example.firstSpring;

public class StaticCats extends Animal {
    public StaticCats(int id, String name, int price) {
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

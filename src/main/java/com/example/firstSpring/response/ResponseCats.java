package com.example.firstSpring.response;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ResponseCats {
    String name;
    int price ;
    public ResponseCats(String name,int price){
        this.name=name;
        this.price=price;
    }
}

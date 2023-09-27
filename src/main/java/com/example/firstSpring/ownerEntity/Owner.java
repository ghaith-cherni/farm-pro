package com.example.firstSpring.ownerEntity;


import com.example.firstSpring.animalEntity.Cats;
import jakarta.persistence.*;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cat_id", referencedColumnName = "id")
    private Cats cats;

}

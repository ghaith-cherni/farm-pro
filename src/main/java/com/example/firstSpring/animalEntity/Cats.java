package com.example.firstSpring.animalEntity;
import com.example.firstSpring.ownerEntity.Owner;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cats")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cats {
    @Id
    @Column(name = "id")
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price;



//    @OneToOne(mappedBy = "cats")
//    private Owner owner;


//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id")
//        private Owner owner;
}


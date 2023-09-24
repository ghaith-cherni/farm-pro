package com.example.firstSpring.ownerRepo;
import com.example.firstSpring.ownerEntity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OwnerRepo extends JpaRepository<Owner, Integer> {

    List<Owner> findByUsername(String username);

}

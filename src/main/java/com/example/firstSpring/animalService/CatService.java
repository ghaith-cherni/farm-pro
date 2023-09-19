package com.example.firstSpring.animalService;

import com.example.firstSpring.animalEntity.Cats;
import com.example.firstSpring.animalRepo.CatRepo;
import com.example.firstSpring.request.CheckCatReq;
import com.example.firstSpring.response.ResponseCats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CatService {
    @Autowired
    CatRepo catRepo;

    public List<Cats> getAllCats() {
        List<Cats> target = new ArrayList<>();
        catRepo.findAll().forEach(target::add);
        return target;
    }

    public Cats createCat(Cats cat) {
        int catId = cat.getId();
        Optional<Cats> dbCat = catRepo.findById(catId);
        if (dbCat.isPresent()) {
            return null;   //
        }
        return catRepo.save(cat);
    }

    public Cats findCat(CheckCatReq checkCatReq) {
        List<Cats> catsByName = catRepo.findByName(checkCatReq.getName());

        if (catsByName.size() == 0) {
            return null;
        } else if (catsByName.size() == 1) {
            return catsByName.get(0);
        } else {
            return catsByName.get(catsByName.size() - 1);
        }

    }

    public ResponseCats findCatByName(CheckCatReq checkCatReq) {
        List<Cats> cats = catRepo.findCatsByName(checkCatReq.getName());
        if (cats.size() == 0) {
            return null;
        } else {
            Cats firstCat = cats.get(0);
            ResponseCats res = new ResponseCats(firstCat.getName(), firstCat.getPrice());
            return res;
        }


    }


//    public  ResponseCats  findByName(CheckCatReq checkCatReq) {
//
//        ResponseCats cat = catRepo.findByName(checkCatReq.getName());
//
//            return cat;
//        } else  return null;
//    }


    public Cats getCatWithId(int id) {

        return catRepo.findById(id).orElse(null);

    }
}


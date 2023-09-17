package com.example.firstSpring.controller;
import com.example.firstSpring.NewCatRequest;
import com.example.firstSpring.NewDogRequest;
import com.example.firstSpring.StaticCats;
import com.example.firstSpring.StaticDogs;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;



@RestController
@RequestMapping("/animals")
public class AnimalController {


    public ArrayList<StaticCats> memoCats= generateCats();
    public ArrayList<StaticDogs> memoDogs= generateDogs();
     @GetMapping("/cats")
    public ArrayList<StaticCats> getAllCats(){

         return memoCats;
     }

    @GetMapping("/dogs")
    public   ArrayList<StaticDogs> getAllDogs() {
        return memoDogs ;
    }

    public static ArrayList<StaticCats> generateCats() {

        ArrayList<StaticCats> cats = new ArrayList<>();

        cats.add(new StaticCats(1, "michou", 30));
        cats.add(new StaticCats(2, "miou", 50));
        cats.add(new StaticCats(3, "mimo", 110));
        cats.add(new StaticCats(4, "ichou", 40));
        cats.add(new StaticCats(5, "chuchu", 200));
        System.out.println(cats);
        return cats;
    }


    public static ArrayList<StaticDogs> generateDogs() {

        ArrayList<StaticDogs> dogs = new ArrayList<>();

        dogs.add(new StaticDogs(1, "milo", 250));
        dogs.add(new StaticDogs(2, "lolu", 150));
        dogs.add(new StaticDogs(3, "dany", 200));
        dogs.add(new StaticDogs(4, "nino", 300));
        dogs.add(new StaticDogs(5, "chuchu", 200));
        System.out.println(dogs);
        return dogs;

    }

    @GetMapping("/cats/{id}")
    public StaticCats getCatById(@PathVariable int id) {
        //ArrayList<StaticCats> cats = new ArrayList<>();
        ArrayList<StaticCats> cats = generateCats();
        for (StaticCats cat : cats) {
            if (cat.getId() == id) {
                return cat;
            }
        }
        return new StaticCats(000, "id not found!", 000);
    }

    @GetMapping("/dogs/{id}")
    public StaticDogs getDogById(@PathVariable int id) {
        // ArrayList<StaticDogs> dogs = new ArrayList<>();
        ArrayList<StaticDogs> dogs = getAllDogs();
        for (StaticDogs dog : dogs) {
            if (dog.getId() == id) {
                return dog;
            }
        }
        System.out.println(" id not found!");
        return null;
    }

    @PostMapping("/addCat")
    public ResponseEntity<String> addCat(@RequestBody NewCatRequest newCatRequest) {
        if (newCatRequest.getId() > 0 && newCatRequest.getName() != null && newCatRequest.getPrice() >= 0 && newCatRequest.getPrice() % 1 == 0) { //price == (int) price
            memoCats.add(new StaticCats(newCatRequest.getId(), newCatRequest.getName(),newCatRequest.getPrice()));

            return ResponseEntity.status(HttpStatus.CREATED).body("Cat added successfully !");

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid id, name or price.");
    }

    @PostMapping("/dogs")
    public ResponseEntity<String> addDog(@RequestBody NewDogRequest newDogRequest) {
        if (newDogRequest.getId() > 0 && newDogRequest.getName() != null && newDogRequest.getPrice() >= 0 && newDogRequest.getPrice() % 1 == 0) { //price == (int) price
            memoDogs.add(new StaticDogs(newDogRequest.getId(), newDogRequest.getName(), newDogRequest.getPrice()));
            return ResponseEntity.status(HttpStatus.CREATED).body("Dog added successfully !");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid id, name or price.");
    }
}


//    @Autowired
//    public CatController(CatService catService) {
//        this.catService = catService;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Cat>> getAllCats() {
//        List<Cat> cats = catService.getAllCats();
//        return ResponseEntity.ok(cats);
//    }


// TODO : endpoint  request post  create cat , create dog  saves it in memory , at
//  the same place where the old list exist all id, name and price are required and price must be integer


//    public void addCat(int id ,String name,int price){
//           getAllCats().add(new StaticCats(id,name,price));
//      }
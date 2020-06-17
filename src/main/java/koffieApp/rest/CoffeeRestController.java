package koffieApp.rest;

import koffieApp.domain.Coffee;
import koffieApp.service.CoffeeService;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class CoffeeRestController {

    @Autowired
    CoffeeService coffeeService;

    @GetMapping("/Coffees")
    public List<Coffee> getCoffees(){
        return coffeeService.getAllCoffees();
    }

    @PostMapping(value = "/Coffees", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addCoffee(@RequestBody Coffee coffee){
        String response = coffeeService.AddNewCoffee(coffee);
        if (response == "coffeeName"){
            return new ResponseEntity<>(
                    Collections.singletonMap("response", response), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(
                    Collections.singletonMap("response", response), HttpStatus.OK);
        }

    }

    @PostMapping(value = "/coffee", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editCoffee(@RequestBody Coffee coffee){
        String response = coffeeService.UpdateExistingCoffee(coffee);
        if (response == "nameExists"){
            return new ResponseEntity<>(
                    Collections.singletonMap("response", response), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(
                    Collections.singletonMap("response", response), HttpStatus.OK);
        }
    }

    @GetMapping(value = "/coffee", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteCoffee(@RequestParam String coffeeId){
        Coffee coffee = coffeeService.getCoffeeById(Integer.parseInt(coffeeId));
        String response = coffeeService.deleteCoffee(coffee);
        return new ResponseEntity<>(
                Collections.singletonMap("response", response), HttpStatus.OK);
    }

    @GetMapping("/coffee/id")
    public Coffee getCoffeeById(@RequestParam Integer coffeeId){
        return coffeeService.getCoffeeById(coffeeId);
    }

}

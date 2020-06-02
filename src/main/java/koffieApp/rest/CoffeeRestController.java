package koffieApp.rest;

import koffieApp.domain.Coffee;
import koffieApp.service.CoffeeService;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @PostMapping("/Coffees")
    void addCoffee(@RequestBody Coffee coffee){
        coffeeService.AddNewCoffee(coffee);
    }

    @PostMapping(value = "/editCoffee", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> editCoffee(@RequestBody Coffee coffee){
        String response = coffeeService.UpdateExistingCoffee(coffee);
        return  Collections.singletonMap("response", response);
    }

    @PostMapping("/deleteCoffee")
    public void deleteCoffee(@RequestBody Coffee coffee){
        coffeeService.deleteCoffee(coffee);
    }

    @GetMapping("/getCoffeeById")
    public Coffee getCoffeeById(@RequestParam Integer coffeeId){
        return coffeeService.getCoffeeById(coffeeId);
    }

}

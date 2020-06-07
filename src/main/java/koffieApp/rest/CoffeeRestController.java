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

    @PostMapping(value = "/Coffee/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> addCoffee(@RequestBody Coffee coffee){
        String response = coffeeService.AddNewCoffee(coffee);
        return Collections.singletonMap("response", response);
    }

    @PostMapping(value = "/coffee/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> editCoffee(@RequestBody Coffee coffee){
        String response = coffeeService.UpdateExistingCoffee(coffee);
        return  Collections.singletonMap("response", response);
    }

    @PostMapping(value = "/coffee/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,String> deleteCoffee(@RequestBody Coffee coffee){
        String response = coffeeService.deleteCoffee(coffee);
        return Collections.singletonMap("response", response);
    }

    @GetMapping("/coffee/id")
    public Coffee getCoffeeById(@RequestParam Integer coffeeId){
        return coffeeService.getCoffeeById(coffeeId);
    }

}

package koffieApp.dao;

import koffieApp.domain.Coffee;
import koffieApp.repository.CoffeeCrudRepository;
import koffieApp.repository.CoffeeQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoffeeDao implements CoffeeDaoInterface<Coffee> {

    @Autowired
    CoffeeCrudRepository CrudRepo;
    @Autowired
    CoffeeQueryRepository Queryrepo;

    @Override
    public Coffee GetCoffeeById(int id){
        return (Coffee) CrudRepo.findById(id).get();
    }

    @Override
    public List<Coffee> GetAllCoffees(){
        List<Coffee> listOfAllCoffees = new ArrayList<Coffee>();
        CrudRepo.findAll().forEach(Coffee -> listOfAllCoffees.add((koffieApp.domain.Coffee) Coffee));
        return listOfAllCoffees;
    }


    public void saveCoffee(Coffee coffee){
        CrudRepo.save(coffee);
    };

    public void updateCoffee(Coffee coffee){
        CrudRepo.save(coffee);
    };


    public void deleteCoffee(Coffee coffee){
        CrudRepo.deleteById(coffee.getId());
    };

    public Coffee getCoffeeByName(String coffeeName){
        Coffee coffee = Queryrepo.findCoffeeByCoffeeName(coffeeName);
        return  coffee;
    }


}

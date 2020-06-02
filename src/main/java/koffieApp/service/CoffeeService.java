package koffieApp.service;

import koffieApp.dao.CoffeeDao;
import koffieApp.domain.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {

    @Autowired
    private CoffeeDao dao;

    public String AddNewCoffee(Coffee coffee){
        if (CheckIfCoffeeNameExists(coffee.getCoffeeName()) == true){
            return "coffee name already exists";
        }
        else{
            dao.saveCoffee(coffee);
            return "coffee succesfully added";
        }
    }

    public String UpdateExistingCoffee(Coffee coffee){
        Coffee coffeeWithSameName = dao.getCoffeeByName(coffee.getCoffeeName());
        if (coffeeWithSameName == null)
        {
            dao.updateCoffee(coffee);
            return "succes";
        }
        else{
            if (coffeeWithSameName.getId() == coffee.getId()){
                dao.updateCoffee(coffee);
                return "succes";
            }
            else{
                return "nameExists";
            }
        }



    }

    public String deleteCoffee(Coffee coffee){
        dao.deleteCoffee(coffee);
        return "deleted succesfully";
    }

    public boolean CheckIfCoffeeNameExists(String coffeeName){
        Coffee coffee = dao.getCoffeeByName(coffeeName);
        if (coffee != null){
            return  true;
        }
        else{
            return false;
        }
    }

    public List<Coffee> getAllCoffees(){
        return dao.GetAllCoffees();
    }

    public Coffee getCoffeeById(Integer coffeeId){
        return dao.GetCoffeeById(coffeeId);
    }
}

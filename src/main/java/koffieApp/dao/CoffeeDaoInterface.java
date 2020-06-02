package koffieApp.dao;

import java.util.List;

public interface CoffeeDaoInterface<Coffee> {

    Coffee GetCoffeeById(int id);

    List<Coffee> GetAllCoffees();

    void saveCoffee(Coffee coffee);

    void updateCoffee(Coffee coffee);

    void deleteCoffee(Coffee coffee);

}

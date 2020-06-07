package com.example.koffieapp;

import koffieApp.KoffieAppApplication;
import koffieApp.dao.CoffeeDao;
import koffieApp.domain.Coffee;
import koffieApp.repository.CoffeeCrudRepository;
import koffieApp.repository.CoffeeQueryRepository;
import koffieApp.service.CoffeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(classes = KoffieAppApplication.class)
public class CoffeeServiceTests {
    @Autowired
    CoffeeService coffeeService;
    @Autowired
    CoffeeQueryRepository coffeeQueryRepository;
    @Autowired
    CoffeeDao coffeeDao;
    @Autowired
    CoffeeCrudRepository coffeeCrudRepository;

    @Test
    void Test_AddNewCoffee_Success(){
        Coffee testCoffee = new Coffee();
        testCoffee.setCoffeeName("testKoffieSucces");
        testCoffee.setCoffeeDescription("testdescription");
        testCoffee.setCoffeePrice(2.0);
        coffeeService.AddNewCoffee(testCoffee);

        Coffee coffeeFromDb = coffeeService.getCoffeeById(testCoffee.getId());

        assertEquals(testCoffee.getId(), coffeeFromDb.getId());

    }

    @Test
    void Test_AddNewCoffee_coffeeNameError(){
        Coffee testCoffee = new Coffee();
        testCoffee.setCoffeeName("testKoffieNameError");
        testCoffee.setCoffeeDescription("testdescription");
        testCoffee.setCoffeePrice(2.0);
        coffeeDao.saveCoffee(testCoffee);
        Coffee testCoffeeSameName = new Coffee();
        testCoffeeSameName.setCoffeeName("testKoffieNameError");
        testCoffeeSameName.setCoffeeDescription("testdescriptionSameName");
        testCoffeeSameName.setCoffeePrice(2.0);

        String response = coffeeService.AddNewCoffee(testCoffeeSameName);

        assertEquals("coffeeName", response);

    }

    @Test
    void Test_UpdateExistingCoffee_Succes(){
        Coffee testCoffee = new Coffee();
        testCoffee.setCoffeeName("testKoffieUpdate");
        testCoffee.setCoffeeDescription("testdescription");
        testCoffee.setCoffeePrice(2.0);
        coffeeDao.saveCoffee(testCoffee);
        testCoffee.setCoffeeName("testKoffieUpdateSucces");
        coffeeService.UpdateExistingCoffee(testCoffee);

        Coffee coffee = coffeeDao.GetCoffeeById(testCoffee.getId());

        assertEquals("testKoffieUpdateSucces", coffee.getCoffeeName());
    }

    @Test
    void Test_UpdateExistingCoffee_NameExistsError(){
        Coffee testCoffee = new Coffee();
        testCoffee.setCoffeeName("testKoffieUpdateError");
        testCoffee.setCoffeeDescription("testdescription");
        testCoffee.setCoffeePrice(2.0);
        coffeeDao.saveCoffee(testCoffee);
        Coffee testCoffeeSameName = new Coffee();
        testCoffeeSameName.setCoffeeName("testKoffieUpdateError");

        String response = coffeeService.UpdateExistingCoffee(testCoffeeSameName);

        assertEquals("nameExists", response);
    }

    @Test
    void Test_DeleteCoffee_Succes(){
        Coffee testCoffee = new Coffee();
        testCoffee.setCoffeeName("testKoffiedelete");
        testCoffee.setCoffeeDescription("testdescription");
        testCoffee.setCoffeePrice(2.0);
        coffeeDao.saveCoffee(testCoffee);

        coffeeService.deleteCoffee(testCoffee);

        Coffee deletedCoffee = coffeeDao.getCoffeeByName("testKoffiedelete");

        assertEquals(null , deletedCoffee);
    }

    @Test
    void Test_GetAllCoffees(){
        Coffee testCoffee = new Coffee();
        testCoffee.setCoffeeName("testKoffieGetAll");
        testCoffee.setCoffeeDescription("testdescription");
        testCoffee.setCoffeePrice(2.0);
        coffeeDao.saveCoffee(testCoffee);
        Coffee testCoffee2 = new Coffee();
        testCoffee2.setCoffeeName("testKoffieGetAll2");
        testCoffee2.setCoffeeDescription("testdescription");
        testCoffee2.setCoffeePrice(2.0);
        coffeeDao.saveCoffee(testCoffee2);

        List<Integer> coffeeList = new ArrayList<Integer>();

        coffeeList.add(testCoffee.getId());
        coffeeList.add(testCoffee2.getId());

        List<Integer> coffeeList2 = new ArrayList<Integer>();
        coffeeService.getAllCoffees().forEach(coffee -> coffeeList2.add(coffee.getId()));

        assertEquals(coffeeList, coffeeList2);

    }

    @Test
    void Test_GetCoffeeById(){
        Coffee testCoffee = new Coffee();
        testCoffee.setCoffeeName("testKoffieById");
        testCoffee.setCoffeeDescription("testdescription");
        testCoffee.setCoffeePrice(2.0);
        coffeeDao.saveCoffee(testCoffee);

        Coffee actual = coffeeService.getCoffeeById(testCoffee.getId());

        assertEquals(testCoffee.getId(), actual.getId());

    }
}

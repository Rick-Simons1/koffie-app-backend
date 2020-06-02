package koffieApp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Coffee {
    @Id
    @GeneratedValue
    Integer Id;
    @Column(unique = true)
    String coffeeName;
    Double CoffeePrice;
    String CoffeeDescription;

    public Coffee() {
    }

    public Coffee(String coffeeName, String coffeeDescription, Double coffeePrice){
        this.coffeeName = coffeeName;
        this.CoffeePrice = coffeePrice;
        this.CoffeeDescription = coffeeDescription;
    }

    public Integer getId() {
        return Id;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public Double getCoffeePrice() {
        return CoffeePrice;
    }

    public String getCoffeeDescription() {
        return CoffeeDescription;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public void setCoffeePrice(Double coffeePrice) {
        CoffeePrice = coffeePrice;
    }

    public void setCoffeeDescription(String coffeeDescription) {
        CoffeeDescription = coffeeDescription;
    }
}

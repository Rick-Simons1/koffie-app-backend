package koffieApp.domain;



import javax.persistence.*;
import javax.swing.*;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private String username;
    private String password;
    private Integer amountOfOrdersDelivered;
    private Integer amountOfCoffeesOrdered;
    private String name;



    public User(){

    }

    public void addCoffeeToAmount(){
        if (amountOfCoffeesOrdered == null){
            amountOfCoffeesOrdered = 0;
        }
        amountOfCoffeesOrdered = amountOfCoffeesOrdered + 1;
    }

    public void addOrderToOrdersDelivered(){
        if (amountOfOrdersDelivered == null)
        {
            amountOfOrdersDelivered = 0;
        }
        amountOfOrdersDelivered = amountOfOrdersDelivered + 1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword(){return password;}

    public void setPassword(String password){this.password = password;}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAmountOfCoffeesOrdered() {
        return amountOfCoffeesOrdered;
    }

    public void setAmountOfCoffeesOrdered(Integer amountOfCoffeesOrdered) {
        this.amountOfCoffeesOrdered = amountOfCoffeesOrdered;
    }

    public Integer getAmountOfOrdersDelivered() {
        return amountOfOrdersDelivered;
    }

    public void setAmountOfOrdersDelivered(Integer amountOfOrdersDelivered) {
        this.amountOfOrdersDelivered = amountOfOrdersDelivered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

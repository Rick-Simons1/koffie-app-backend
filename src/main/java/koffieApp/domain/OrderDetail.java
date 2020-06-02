package koffieApp.domain;

import javax.persistence.*;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer orderDetailId;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    private Integer coffeeId;
    private String  coffeeName;
    private Integer amountOfSugar;
    private Integer amountOfMilk;
    private String coffeeCode;
    private Integer placedByUserId;




    public OrderDetail() {
    }

    public OrderDetail(Integer coffeeId, Integer amountOfSugar, Integer amountOfMilk, Integer userId){
        this.coffeeId = coffeeId;
        this.amountOfSugar = amountOfSugar;
        this.amountOfMilk = amountOfMilk;
        this.placedByUserId = userId;

    }
    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public Integer getPlacedByUserId() {
        return placedByUserId;
    }

    public void setPlacedByUserId(Integer placedById) {
        this.placedByUserId = placedById;
    }

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Integer getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(Integer coffeeId) {
        this.coffeeId = coffeeId;
    }

    public Integer getAmountOfSugar() {
        return amountOfSugar;
    }

    public void setAmountOfSugar(Integer amountOfSugar) {
        this.amountOfSugar = amountOfSugar;
    }

    public Integer getAmountOfMilk() {
        return amountOfMilk;
    }

    public void setAmountOfMilk(Integer amountOfMilk) {
        this.amountOfMilk = amountOfMilk;
    }

    public String getCoffeeCode() {
        return coffeeCode;
    }

    public void setCoffeeCode(String coffeeCode) {
        this.coffeeCode = coffeeCode;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

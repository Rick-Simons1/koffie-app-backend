package koffieApp.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "order_id")
    private Integer id;
    private LocalDateTime dayOfOrder;
    private Integer deliveredByID;
    @OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true, mappedBy = "order")
    private List<OrderDetail> listOfOrderDetails;

    public Order() {
        listOfOrderDetails = new ArrayList<OrderDetail>();
        this.dayOfOrder = LocalDateTime.now();
    }

    public Order(Integer deliveredByID) {
        this.deliveredByID = deliveredByID;
        listOfOrderDetails = new ArrayList<OrderDetail>();
        this.dayOfOrder = LocalDateTime.now();
    }

    public void AddOrderDetail(OrderDetail orderDetail){
        listOfOrderDetails.add(orderDetail);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDayOfOrder() {
        return dayOfOrder;
    }

    public void setDayOfOrder(LocalDateTime dayOfOrder) {
        this.dayOfOrder = dayOfOrder;
    }

    public Integer getDeliveredByID() {
        return deliveredByID;
    }

    public void setDeliveredByID(Integer deliveredByID) {
        this.deliveredByID = deliveredByID;
    }

    public List<OrderDetail> getListOfOrderDetails() {
        return listOfOrderDetails;
    }

    public void setListOfOrderDetails(List<OrderDetail> listOfOrderDetails) {
        this.listOfOrderDetails = listOfOrderDetails;
    }
}

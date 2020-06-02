package koffieApp.dao;

import koffieApp.domain.Order;
import koffieApp.domain.User;
import koffieApp.repository.OrderCrudrepository;
import koffieApp.repository.OrderQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDao {
    @Autowired
    OrderCrudrepository crudrepo;
    @Autowired
    OrderQueryRepository queryrepo;

    public Order GetOrderById(int id){
        return (Order) crudrepo.findById(id).get();
    }

    public List<Order> GetAllOrders(){
        List<Order> listOfAllOrders = new ArrayList<>();
        crudrepo.findAll().forEach(Order -> listOfAllOrders.add((koffieApp.domain.Order) Order));
        return  listOfAllOrders;
    }

    public void saveOrder(Order order){
        crudrepo.save(order);
    }

    public void updateOrder(Order order){
        crudrepo.save(order);
    }

    public void deleteOrder(Order order){
        crudrepo.delete(order);
    }

    public Order getLastOrder(){
        Order order = queryrepo.findFirstByOrderByIdDesc();
        return  order;
    }


}

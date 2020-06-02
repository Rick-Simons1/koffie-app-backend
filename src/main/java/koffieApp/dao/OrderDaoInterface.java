package koffieApp.dao;

import koffieApp.domain.Order;

import java.util.List;

public interface OrderDaoInterface {
    Order GetOrderById(int id);

    List<Order> GetAllOrders();

    void saveOrder(Order order);

    void updateOrder(Order order);

    void deleteOrder(Order order);
}

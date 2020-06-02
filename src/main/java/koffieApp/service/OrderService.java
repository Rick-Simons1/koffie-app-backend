package koffieApp.service;

import koffieApp.dao.OrderDao;
import koffieApp.dao.UserDao;
import koffieApp.domain.Order;
import koffieApp.domain.OrderDetail;
import koffieApp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private OrderDao dao;
    @Autowired
    private OrderDetailService service;

    public void makeOrder(Integer id){
        User user =userDao.getUserById(id);
        user.addOrderToOrdersDelivered();
        userDao.updateUser(user);
        Order order = new Order();
        order.setDeliveredByID(id);
        dao.saveOrder(order);

    }

    public void addOrderDetailsToOrder(List<OrderDetail> orderDetails){
        Order order = dao.getLastOrder();
        for (OrderDetail orderdetail: orderDetails) {
            orderdetail.setOrder(order);
            service.updateOrderDetail(orderdetail);
        }
    }



    public List<Order> getAllOrders(){

        return  dao.GetAllOrders();
    }

    public String deleteOrder(Order order){
        dao.deleteOrder(order);
        return "order deleted succesfully";
    }

    public String updateOrder(Order order){
        dao.updateOrder(order);
        return "order updated succesfully";
    }






}

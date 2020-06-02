package koffieApp.service;

import koffieApp.dao.OrderDetailDao;
import koffieApp.domain.Order;
import koffieApp.domain.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailService {

    @Autowired
    OrderDetailDao dao;

    public String placeOrderDetail(OrderDetail orderDetail){
        dao.saveOrderDetail(orderDetail);
        return "coffee order placed succesfully";

    }

    public String deleteOrderDetail(OrderDetail orderDetail){
        dao.deleteOrderDetail(orderDetail);
        return "coffee order deleted succesfully";
    }

    public String updateOrderDetail(OrderDetail orderDetail){
        dao.updateOrderDetail(orderDetail);
        return "coffee order updated succesfully";
    }

    public List<OrderDetail> getAllOrderDetailsWithoutOrder(){
        List<OrderDetail> orderDetailsWithoutOrder = dao.getAllOrderDetailsWithoutOrder();
        return orderDetailsWithoutOrder;

    }

    public OrderDetail getOrderDetailById(Integer id){
        return  dao.GetOrderDetailById(id);
    }

}

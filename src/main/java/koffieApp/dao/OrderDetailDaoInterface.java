package koffieApp.dao;

import koffieApp.domain.Order;
import koffieApp.domain.OrderDetail;

import java.util.List;

public interface OrderDetailDaoInterface {
    OrderDetail GetOrderDetailById(int id);

    List<OrderDetail> GetAllOrderDetails();

    void saveOrderDetail(OrderDetail orderDetail);

    void updateOrderDetail(OrderDetail orderDetail);

    void deleteOrderDetail(OrderDetail orderDetail);
}

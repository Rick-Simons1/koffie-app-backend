package koffieApp.dao;

import koffieApp.domain.OrderDetail;
import koffieApp.repository.OrderDetailCrudRepository;
import koffieApp.repository.OrderDetailQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailDao {
    @Autowired
    OrderDetailCrudRepository crudRepo;
    @Autowired
    OrderDetailQueryRepository queryRepo;

    public OrderDetail GetOrderDetailById(int id){
       return crudRepo.findById(id).get();
    }

    public List<OrderDetail> GetAllOrderDetails(){
        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        crudRepo.findAll().forEach(OrderDetail -> orderDetailList.add(OrderDetail));
        return orderDetailList;
    }

    public void saveOrderDetail(OrderDetail orderDetail){
        crudRepo.save(orderDetail);
    }

    public void updateOrderDetail(OrderDetail orderDetail){
        crudRepo.save(orderDetail);
    }

    public void deleteOrderDetail(OrderDetail orderDetail){
        crudRepo.delete(orderDetail);
    }

    public List<OrderDetail> getAllOrderDetailsWithoutOrder(){
        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        orderDetailList = queryRepo.findAllByOrder_Id(null);
        return orderDetailList;

    }





}

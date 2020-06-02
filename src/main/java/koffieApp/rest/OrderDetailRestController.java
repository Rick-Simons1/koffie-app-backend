package koffieApp.rest;

import koffieApp.domain.OrderDetail;
import koffieApp.service.OrderDetailService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderDetailRestController {
    @Autowired
    OrderDetailService orderDetailService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping("/addOrderDetail")
    public void addOrderDetail(@RequestBody OrderDetail orderDetail){
        orderDetailService.placeOrderDetail(orderDetail);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/getOrderDetails")
    public List<OrderDetail> getOrderDetails(){
        return orderDetailService.getAllOrderDetailsWithoutOrder();
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping("/deleteOrderDetail")
    public String deleteOrderDetail(@RequestBody OrderDetail orderDetail){
        return orderDetailService.deleteOrderDetail(orderDetail);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping("/updateOrderDetail")
    public String updateOrderDetail(@RequestBody OrderDetail orderDetail){
        return orderDetailService.updateOrderDetail(orderDetail);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/getOrderDetailById")
    public OrderDetail getOrderDetailById(@RequestParam int orderDetailId){
        return orderDetailService.getOrderDetailById(orderDetailId);
    }



}

package koffieApp.rest;

import koffieApp.domain.OrderDetail;
import koffieApp.service.OrderDetailService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class OrderDetailRestController {
    @Autowired
    OrderDetailService orderDetailService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping("/orderdetail/create")
    public Map<String, String> addOrderDetail(@RequestBody OrderDetail orderDetail){
        String response = orderDetailService.placeOrderDetail(orderDetail);
        return Collections.singletonMap("response", response);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/orderdetails")
    public List<OrderDetail> getOrderDetails(){
        return orderDetailService.getAllOrderDetailsWithoutOrder();
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping("/orderdetail/delete")
    public String deleteOrderDetail(@RequestBody OrderDetail orderDetail){
        return orderDetailService.deleteOrderDetail(orderDetail);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping("/orderdetail/update")
    public String updateOrderDetail(@RequestBody OrderDetail orderDetail){
        return orderDetailService.updateOrderDetail(orderDetail);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/orderdetail/id")
    public OrderDetail getOrderDetailById(@RequestParam int orderDetailId){
        return orderDetailService.getOrderDetailById(orderDetailId);
    }



}

package koffieApp.rest;

import koffieApp.domain.OrderDetail;
import koffieApp.service.OrderDetailService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class OrderDetailRestController {
    @Autowired
    OrderDetailService orderDetailService;

    @PostMapping("/orderdetails")
    public ResponseEntity addOrderDetail(@RequestBody OrderDetail orderDetail){
        String response = orderDetailService.placeOrderDetail(orderDetail);
        return new ResponseEntity<>(
                Collections.singletonMap("response", response), HttpStatus.OK);
    }

    @GetMapping("/orderdetails")
    public List<OrderDetail> getOrderDetails(){
        return orderDetailService.getAllOrderDetailsWithoutOrder();
    }

    @GetMapping("/orderdetail")
    public ResponseEntity deleteOrderDetail(@RequestBody OrderDetail orderDetail){
        String response = orderDetailService.deleteOrderDetail(orderDetail);
        return new ResponseEntity<>(
                Collections.singletonMap("response", response), HttpStatus.OK);
    }

    @PostMapping("/orderdetail")
    public ResponseEntity updateOrderDetail(@RequestBody OrderDetail orderDetail){
        String response = orderDetailService.updateOrderDetail(orderDetail);
        return new ResponseEntity<>(
                Collections.singletonMap("response", response), HttpStatus.OK);
    }

    @GetMapping("/orderdetail/id")
    public OrderDetail getOrderDetailById(@RequestParam int orderDetailId){
        return orderDetailService.getOrderDetailById(orderDetailId);
    }



}

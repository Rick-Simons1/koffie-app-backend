package koffieApp.rest;

import koffieApp.domain.Order;
import koffieApp.domain.OrderDetail;
import koffieApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class OrderRestController {
    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public List<Order> getOrders(){
        return orderService.getAllOrders();
    }

    @PostMapping("/orders")
    public ResponseEntity placeOrder(@RequestParam String userId, @RequestBody List<OrderDetail> listOfOrderDetails){
        int id = Integer.parseInt(userId);
        String response = orderService.makeOrder(id);
        orderService.addOrderDetailsToOrder(listOfOrderDetails);
        return new ResponseEntity<>(
                Collections.singletonMap("response", response), HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity updateOrder(@RequestBody Order order){
        String response = orderService.updateOrder(order);
        return new ResponseEntity<>(
                Collections.singletonMap("response", response), HttpStatus.OK);
    }

    @GetMapping("/order")
    public ResponseEntity deleteOrder(@RequestBody Order order){
        String response = orderService.deleteOrder(order);
        return new ResponseEntity<>(
                Collections.singletonMap("response", response), HttpStatus.OK);
    }
}

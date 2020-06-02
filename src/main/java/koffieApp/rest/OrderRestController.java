package koffieApp.rest;

import koffieApp.domain.Order;
import koffieApp.domain.OrderDetail;
import koffieApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OrderRestController {
    @Autowired
    OrderService orderService;

    @GetMapping("/getOrders")
    public List<Order> getOrders(){
        return orderService.getAllOrders();
    }

    @PostMapping("/placeOrder")
    public void placeOrder(@RequestParam String userId, @RequestBody List<OrderDetail> listOfOrderDetails){
        int id = Integer.parseInt(userId);
        orderService.makeOrder(id);
        orderService.addOrderDetailsToOrder(listOfOrderDetails);
    }

    @PostMapping("/updateOrder")
    public String updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }

    @PostMapping("/deleteOrder")
    public String deleteOrder(@RequestBody Order order){
        return orderService.deleteOrder(order);
    }
}

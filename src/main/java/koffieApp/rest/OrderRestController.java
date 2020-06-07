package koffieApp.rest;

import koffieApp.domain.Order;
import koffieApp.domain.OrderDetail;
import koffieApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/order/create")
    public Map<String, String> placeOrder(@RequestParam String userId, @RequestBody List<OrderDetail> listOfOrderDetails){
        int id = Integer.parseInt(userId);
        String response = orderService.makeOrder(id);
        orderService.addOrderDetailsToOrder(listOfOrderDetails);
        return Collections.singletonMap("response", response);

    }

    @PostMapping("/order/update")
    public String updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }

    @PostMapping("/order/delete")
    public String deleteOrder(@RequestBody Order order){
        return orderService.deleteOrder(order);
    }
}

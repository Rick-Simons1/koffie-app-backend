package com.example.koffieapp;

import koffieApp.KoffieAppApplication;
import koffieApp.dao.OrderDao;
import koffieApp.dao.OrderDetailDao;
import koffieApp.dao.UserDao;
import koffieApp.domain.Order;
import koffieApp.domain.OrderDetail;
import koffieApp.domain.User;
import koffieApp.repository.OrderCrudrepository;
import koffieApp.repository.OrderDetailQueryRepository;
import koffieApp.repository.OrderQueryRepository;
import koffieApp.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(classes = KoffieAppApplication.class)
public class OrderServiceTests {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderQueryRepository orderQueryRepository;
    @Autowired
    OrderCrudrepository orderCrudrepository;
    @Autowired
    OrderDao orderDao;
    @Autowired
    UserDao userDao;
    @Autowired
    OrderDetailDao orderDetailDao;
    @Autowired
    OrderDetailQueryRepository orderDetailQueryRepository;


    @Test
    void Test_MakeOrder_Succes(){
        User testUser = new User();
        testUser.setName("testnameMakeOrder");
        userDao.saveUser(testUser);

        orderService.makeOrder(testUser.getId());

        Order order = orderQueryRepository.findFirstByOrderByIdDesc();

        assertEquals(testUser.getId(), order.getDeliveredByID());
    }


    @Test
    void Test_addOrderDetailsToOrder(){
        User testUser = new User();
        testUser.setName("testnameMakeOrder");
        userDao.saveUser(testUser);

        orderService.makeOrder(testUser.getId());
        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setPlacedByUserId(testUser.getId());
        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setPlacedByUserId(testUser.getId());
        orderDetailDao.saveOrderDetail(orderDetail1);
        orderDetailDao.saveOrderDetail(orderDetail2);

        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        orderDetailList.add(orderDetail1);
        orderDetailList.add(orderDetail2);

        orderService.addOrderDetailsToOrder(orderDetailList);

        Order order = orderQueryRepository.findFirstByOrderByIdDesc();

        List<Integer> orderDetailIdListExpected = new ArrayList<Integer>();
        orderDetailIdListExpected.add(orderDetail1.getOrderDetailId());
        orderDetailIdListExpected.add(orderDetail2.getOrderDetailId());

        List<Integer> orderDetailIdListActual = new ArrayList<Integer>();

        orderDetailQueryRepository.findAllByOrder_Id(order.getId()).forEach(orderDetail -> orderDetailIdListActual.add(orderDetail.getOrderDetailId()));


        assertEquals(orderDetailIdListExpected, orderDetailIdListActual);
    }

    @Test
    void Test_deleteOrder(){
        User testUser = new User();
        testUser.setName("testnameDeleteOrder");
        userDao.saveUser(testUser);
        Order order = new Order();
        order.setDeliveredByID(testUser.getId());

        orderService.deleteOrder(order);

        Order orderActual = orderQueryRepository.findFirstByOrderByIdDesc();

        assertEquals(null, orderActual);
    }

    @Test
    void Test_UpdateOrder(){
        User testUser = new User();
        testUser.setName("testnameUpdateOrder");
        userDao.saveUser(testUser);
        User testUserUpdate = new User();
        testUserUpdate.setName("testnameUpdateOrderUpdated");
        userDao.saveUser(testUserUpdate);
        Order order = new Order();
        order.setDeliveredByID(testUser.getId());
        orderDao.saveOrder(order);
        order.setDeliveredByID(testUserUpdate.getId());
        orderService.updateOrder(order);

        Order orderActual = orderQueryRepository.findFirstByOrderByIdDesc();

        assertEquals(testUserUpdate.getId(), orderActual.getDeliveredByID());
    }

    @Test
    void Test_GetAllOrder(){
        Order testorder1 = new Order();
        Order testorder2 = new Order();

        orderDao.saveOrder(testorder1);
        orderDao.saveOrder(testorder2);

        List<Integer> orderlistExpected = new ArrayList<Integer>();
        orderlistExpected.add(testorder1.getId());
        orderlistExpected.add(testorder2.getId());

        List<Integer>orderListActual = new ArrayList<Integer>();
        orderService.getAllOrders().forEach(order -> orderListActual.add(order.getId()));

        assertEquals(orderlistExpected, orderListActual);


    }




}


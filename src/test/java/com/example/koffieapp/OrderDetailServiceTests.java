package com.example.koffieapp;

import koffieApp.KoffieAppApplication;
import koffieApp.dao.OrderDetailDao;
import koffieApp.dao.UserDao;
import koffieApp.domain.OrderDetail;
import koffieApp.domain.User;
import koffieApp.repository.OrderDetailCrudRepository;
import koffieApp.repository.OrderDetailQueryRepository;
import koffieApp.service.OrderDetailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(classes = KoffieAppApplication.class)
public class OrderDetailServiceTests {
    @Autowired
    OrderDetailService orderDetailService;
    @Autowired
    OrderDetailQueryRepository orderDetailQueryRepository;
    @Autowired
    OrderDetailDao orderDetailDao;
    @Autowired
    OrderDetailCrudRepository orderDetailCrudRepository;
    @Autowired
    UserDao userDao;

    @Test
    void Test_AddOrderDetail_Succes(){
        User testuser = new User();
        testuser.setPassword("password");
        testuser.setUsername("testusernameAdd");
        testuser.setName("testname");
        userDao.saveUser(testuser);
        OrderDetail testOrderDetail = new OrderDetail();
        testOrderDetail.setCoffeeName("testCoffeeName");
        testOrderDetail.setPlacedByUserId(testuser.getId());
        testOrderDetail.setCoffeeName("testkoffieName");
        testOrderDetail.setCoffeeId(1);
        testOrderDetail.setAmountOfMilk(1);
        testOrderDetail.setAmountOfSugar(1);
        orderDetailDao.saveOrderDetail(testOrderDetail);

        OrderDetail testOrderDetailActual = orderDetailService.getOrderDetailById(testOrderDetail.getOrderDetailId());

        assertEquals(testOrderDetail.getOrderDetailId(), testOrderDetailActual.getOrderDetailId());

    }

    @Test
    void Test_DeleteOrderDetail_Succes(){
        User testuser = new User();
        testuser.setPassword("password");
        testuser.setUsername("testusernameDelete");
        testuser.setName("testname");
        userDao.saveUser(testuser);
        OrderDetail testOrderDetail = new OrderDetail();
        testOrderDetail.setCoffeeName("testCoffeeNameDelete");
        testOrderDetail.setPlacedByUserId(testuser.getId());
        testOrderDetail.setCoffeeId(1);
        testOrderDetail.setAmountOfMilk(1);
        testOrderDetail.setAmountOfSugar(1);
        orderDetailDao.saveOrderDetail(testOrderDetail);
        orderDetailService.deleteOrderDetail(testOrderDetail);

        OrderDetail testOrderDetailActual = orderDetailQueryRepository.findByCoffeeName(testOrderDetail.getCoffeeName());

        assertEquals(null, testOrderDetailActual);

    }

    @Test
    void Test_UpdateOrderDetail_Succes(){
        User testuser = new User();
        testuser.setPassword("password");
        testuser.setUsername("testusernameUpdate");
        testuser.setName("testname");
        userDao.saveUser(testuser);
        OrderDetail testOrderDetail = new OrderDetail();
        testOrderDetail.setCoffeeName("testCoffeeNameUpdate");
        testOrderDetail.setPlacedByUserId(testuser.getId());
        testOrderDetail.setCoffeeId(1);
        testOrderDetail.setAmountOfMilk(1);
        testOrderDetail.setAmountOfSugar(1);
        orderDetailDao.saveOrderDetail(testOrderDetail);
        testOrderDetail.setCoffeeName("testCoffeeNameUpdatedForTest");
        orderDetailService.updateOrderDetail(testOrderDetail);

        OrderDetail testOrderDetailActual = orderDetailDao.GetOrderDetailById(testOrderDetail.getOrderDetailId());

        assertEquals("testCoffeeNameUpdatedForTest", testOrderDetailActual.getCoffeeName());

    }

    @Test
    void Test_GetAllOrderDetailWithoutOrder(){
        User testuser = new User();
        testuser.setPassword("password");
        testuser.setUsername("testusernameGetAll");
        testuser.setName("testname");
        userDao.saveUser(testuser);
        OrderDetail testOrderDetail = new OrderDetail();
        testOrderDetail.setCoffeeName("testCoffeeNameGetAll");
        testOrderDetail.setPlacedByUserId(testuser.getId());
        testOrderDetail.setCoffeeId(1);
        testOrderDetail.setAmountOfMilk(1);
        testOrderDetail.setAmountOfSugar(1);
        orderDetailDao.saveOrderDetail(testOrderDetail);
        User testuser1 = new User();
        testuser1.setPassword("password");
        testuser1.setUsername("testusernameGetAll1");
        testuser1.setName("testname");
        userDao.saveUser(testuser1);
        OrderDetail testOrderDetail1 = new OrderDetail();
        testOrderDetail1.setCoffeeName("testCoffeeNameGetAll1");
        testOrderDetail1.setPlacedByUserId(testuser.getId());
        testOrderDetail1.setCoffeeId(1);
        testOrderDetail1.setAmountOfMilk(1);
        testOrderDetail1.setAmountOfSugar(1);
        orderDetailDao.saveOrderDetail(testOrderDetail1);


        List<Integer> orderDetailList = new ArrayList<Integer>();
        orderDetailList.add(testOrderDetail.getOrderDetailId());
        orderDetailList.add(testOrderDetail1.getOrderDetailId());


        List<Integer> orderDetailList2 = new ArrayList<Integer>();
        orderDetailService.getAllOrderDetailsWithoutOrder().forEach(orderDetail -> orderDetailList2.add(orderDetail.getOrderDetailId()));


        assertEquals(orderDetailList, orderDetailList2);

    }



}

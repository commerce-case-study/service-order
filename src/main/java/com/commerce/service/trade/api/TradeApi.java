package com.commerce.service.trade.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.service.trade.dao.OrderDao;
import com.commerce.service.trade.dao.OrderDeliveryDao;
import com.commerce.service.trade.dao.OrderItemDao;
import com.commerce.service.trade.dao.OrderPaymentDao;
import com.commerce.service.trade.dao.ShopDao;
import com.commerce.service.trade.entities.Order;
import com.commerce.service.trade.entities.OrderDelivery;
import com.commerce.service.trade.entities.OrderItem;
import com.commerce.service.trade.entities.OrderPayment;
import com.commerce.service.trade.entities.Shop;

@RestController
public class TradeApi {
    
    Logger logger = LoggerFactory.getLogger(TradeApi.class);
    
    @Autowired
    ShopDao shopDao;
    
    @Autowired
    OrderDao orderDao;
    
    @Autowired
    OrderItemDao orderItemDao;
    
    @Autowired
    OrderDeliveryDao orderDeliveryDao;
    
    @Autowired
    OrderPaymentDao orderPaymentDao;
    
    @PostMapping(value = "createOrder", consumes = "application/json")
    public Long createOrder(@RequestBody Order order) {
        orderDao.save(order);
        return order.getId();
    }
    
    @PostMapping(value = "createOrderItem", consumes = "application/json")
    public Long createOrderItem(@RequestBody OrderItem orderItem) {
        orderItemDao.save(orderItem);
        return orderItem.getId();
    }
    
    @PostMapping(value = "createOrderPayment", consumes = "application/json")
    public Long createOrderPayment(@RequestBody OrderPayment orderPayment) {
        orderPaymentDao.save(orderPayment);
        return orderPayment.getId();
    }
    
    @PostMapping(value = "createOrderDelivery", consumes = "application/json")
    public Long createOrderDelivery(@RequestBody OrderDelivery orderDelivery) {
        orderDeliveryDao.save(orderDelivery);
        return orderDelivery.getId();
    }
    
    @GetMapping(value = "findShopById/{shopId}", produces = "application/json")
    public Shop findShopById(@PathVariable("shopId") Long id) {
        return shopDao.findById(id).orElse(null);
    }
    
    @GetMapping(value = "findOrderByOrderCode/{orderCode}", produces = "application/json")
    public Order findOrderByOrderCode(@PathVariable("orderCode") String orderCode) {
        return orderDao.findByOrderCode(orderCode).orElse(null);
    }
}

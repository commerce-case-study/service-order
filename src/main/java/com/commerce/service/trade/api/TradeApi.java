package com.commerce.service.trade.api;

import java.util.List;

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
    
    @GetMapping(value = "updateOrderStatus/{orderId}/{status}", produces = "application/json")
    public Boolean updateOrderStatus(@PathVariable("orderId") Long orderId, @PathVariable("status") String status) {
    	return orderDao.updateOrderStatus(orderId, status) > 0;
    }
    
    @PostMapping(value = "createOrderItem", consumes = "application/json")
    public Long createOrderItem(@RequestBody OrderItem orderItem) {
        orderItemDao.save(orderItem);
        return orderItem.getId();
    }
    
    @GetMapping(value = "findOrderItemByOrderId/{orderId}", produces = "application/json")
    public List<OrderItem> findOrderItemByOrderId(@PathVariable("orderId") Long orderId) {
        return orderItemDao.findByOrderId(orderId);
    }
    
    @PostMapping(value = "createOrderPayment", consumes = "application/json")
    public Long createOrderPayment(@RequestBody OrderPayment orderPayment) {
        orderPaymentDao.save(orderPayment);
        return orderPayment.getId();
    }
    
    @GetMapping(value = "findOrderPaymentByOrderId/{orderId}", produces = "application/json")
    public OrderPayment findOrderPaymentByOrderId(@PathVariable("orderId") Long orderId) {
        List<OrderPayment> list = orderPaymentDao.findByOrderIdOrderByIdDesc(orderId);
        if(null != list && !list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }
    
    @PostMapping(value = "createOrderDelivery", consumes = "application/json")
    public Long createOrderDelivery(@RequestBody OrderDelivery orderDelivery) {
        orderDeliveryDao.save(orderDelivery);
        return orderDelivery.getId();
    }
    
    @GetMapping(value = "findOrderDeliveryByOrderId/{orderId}", produces = "application/json")
    public OrderDelivery findOrderDeliveryByOrderId(@PathVariable("orderId") Long orderId) {
        return orderDeliveryDao.findByOrderId(orderId).orElse(null);
    }
    
    @GetMapping(value = "findShopById/{shopId}", produces = "application/json")
    public Shop findShopById(@PathVariable("shopId") Long id) {
        return shopDao.findById(id).orElse(null);
    }
    
    @GetMapping(value = "findOrderByOrderCode/{orderCode}", produces = "application/json")
    public Order findOrderByOrderCode(@PathVariable("orderCode") String orderCode) {
        return orderDao.findByOrderCode(orderCode).orElse(null);
    }
    
    @GetMapping(value = "findOrderPaymentByPaymentCode/{paymentCode}", produces = "application/json")
    public OrderPayment findOrderPaymentByPaymentCode(@PathVariable("paymentCode") String paymentCode) {
        return orderPaymentDao.findByPaymentCode(paymentCode).orElse(null);
    }
    
    @GetMapping(value = "updateOrderPaymentStatus/{paymentCode}/{status}", produces = "application/json")
    public boolean updateOrderPaymentStatus(@PathVariable("paymentCode") String paymentCode, @PathVariable("status") String status) {
        return orderPaymentDao.updateOrderPaymentStatus(paymentCode, status) > 0;
    }
}

package com.commerce.service.trade.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.service.trade.entities.OrderItem;

public interface OrderItemDao extends JpaRepository<OrderItem, Long>{

    List<OrderItem> findByOrderId(Long orderId);
}

package com.commerce.service.trade.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.service.trade.entities.OrderItem;

public interface OrderItemDao extends JpaRepository<OrderItem, Long>{

}

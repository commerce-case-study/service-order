package com.commerce.service.trade.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.service.trade.entities.Order;

public interface OrderDao extends JpaRepository<Order, Long>{

}

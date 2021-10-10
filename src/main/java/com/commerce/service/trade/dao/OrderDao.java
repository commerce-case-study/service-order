package com.commerce.service.trade.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.service.trade.entities.Order;

public interface OrderDao extends JpaRepository<Order, Long>{

	Optional<Order> findByOrderCode(String orderCode);
}

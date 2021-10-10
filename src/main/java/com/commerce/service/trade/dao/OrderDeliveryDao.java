package com.commerce.service.trade.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.service.trade.entities.OrderDelivery;

public interface OrderDeliveryDao extends JpaRepository<OrderDelivery, Long>{

    Optional<OrderDelivery> findByOrderId(Long orderId);
}

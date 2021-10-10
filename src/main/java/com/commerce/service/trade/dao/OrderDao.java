package com.commerce.service.trade.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.commerce.service.trade.entities.Order;

public interface OrderDao extends JpaRepository<Order, Long>{

    Optional<Order> findByOrderCode(String orderCode);
    
    @Transactional @Modifying
    @Query("update Order o set o.status = ?2 where o.id = ?1")
    int updateOrderStatus(Long orderId, String status);
    
}

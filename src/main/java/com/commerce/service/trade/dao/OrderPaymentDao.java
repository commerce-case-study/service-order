package com.commerce.service.trade.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.service.trade.entities.OrderPayment;

public interface OrderPaymentDao extends JpaRepository<OrderPayment, Long>{

}

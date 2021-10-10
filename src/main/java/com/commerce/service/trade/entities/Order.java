package com.commerce.service.trade.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="t_trd_order")
public class Order {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "member_id", nullable = false)
    private Long memberId;
    
    @Column(name = "order_code", nullable = false)
    private String orderCode;
    
    private String status;
    
    @Column(name = "shipping_fee")
    private BigDecimal shippingFee;
    
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    
    @Column(name = "total_discount")
    private BigDecimal totalDiscount;
    
    @Column(name = "total_payment")
    private BigDecimal totalPayment;
}

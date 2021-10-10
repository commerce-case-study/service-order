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
@Table(name="t_trd_order_item")
public class OrderItem {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "order_id", nullable = false)
    private Long orderId;
    
    @Column(name = "item_id", nullable = false)
    private Long itemId;
    
    @Column(name = "shop_id")
    private Long shopId;
    
    private String itemName;
    
    private BigDecimal itemPrice;
    
    private Integer quantity;
}

package com.commerce.service.trade.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="t_trd_shop")
public class Shop {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "member_id", nullable = false)
    private Long memberId;
    
    @Column(name = "member_address_id", nullable = false)
    private Long memberAddressId;
    
    @Column(name = "shop_name", nullable = false)
    private String shopName;
    
    private String status;
}

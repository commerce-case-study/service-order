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
@Table(name="t_trd_order_delivery")
public class OrderDelivery {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "order_id", nullable = false)
    private Long orderId;
    
    @Column(name = "courier_name")
    private String courierName;
    
    @Column(name = "awb_number")
    private String awbNumber;
    
    @Column(name = "sender_phone")
    private String senderPhone;
    
    @Column(name = "sender_name")
    private String senderName;
    
    @Column(name = "sender_province")
    private String senderProvince;
    
    @Column(name = "sender_city")
    private String senderCity;
    
    @Column(name = "sender_district")
    private String senderDistrict;
    
    @Column(name = "sender_full_address")
    private String senderFullAddress;
    
    @Column(name = "receiver_phone")
    private String receiverPhone;
    
    @Column(name = "receiver_name")
    private String receiverName;
    
    @Column(name = "receiver_province")
    private String receiverProvince;
    
    @Column(name = "receiver_city")
    private String receiverCity;
    
    @Column(name = "receiver_district")
    private String receiverDistrict;
    
    @Column(name = "receiver_full_address")
    private String receiverFullAddress;
}

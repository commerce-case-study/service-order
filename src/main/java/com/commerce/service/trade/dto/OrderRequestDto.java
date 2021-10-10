package com.commerce.service.trade.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderRequestDto {

    private List<OrderItemRequestDto> items;
    
    private Long memberAddressId;
    
    private String paymentType;
}

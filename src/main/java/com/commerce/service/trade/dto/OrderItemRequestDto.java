package com.commerce.service.trade.dto;

import lombok.Data;

@Data
public class OrderItemRequestDto {

	private Long itemId;
	
	private Integer quantity;
}

package com.commerce.service.trade.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.service.trade.entities.Shop;

public interface ShopDao extends JpaRepository<Shop, Long>{

}

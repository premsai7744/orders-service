package com.myshopping.orders_service.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myshopping.orders_service.entity.OrdersInfo;

@Repository
public interface OrdersInfoRespository extends JpaRepository<OrdersInfo, UUID>{

}

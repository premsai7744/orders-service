package com.myshopping.orders_service.service;

import com.myshopping.orders_service.DTO.OrdersInfoDTO;

import jakarta.validation.Valid;

public interface OrdersService {

	String createOrder(@Valid OrdersInfoDTO ordersInfoDTO);

}

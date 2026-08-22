package com.myshopping.orders_service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myshopping.orders_service.DTO.OrdersInfoDTO;
import com.myshopping.orders_service.service.OrdersService;

import jakarta.validation.Valid;


@RestController
public class OrdersController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrdersController.class);
	
	@Autowired
	OrdersService ordersService;
	
	
	@PostMapping("/create/order")
	public ResponseEntity<String> createOrder(@Valid @RequestBody OrdersInfoDTO ordersInfoDTO){
		logger.info("Request recevied by controller, ordersInfoDTO : {}",ordersInfoDTO);
		
		String response = ordersService.createOrder(ordersInfoDTO);
		
		if(response.contains("Order created successfully")) {
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(response);
		} else {
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(response);
		}
	}
	
	
	@GetMapping("/search/orders/{paidBy}")
	private ResponseEntity<List<OrdersInfoDTO>> searchOrders(@PathVariable String paidBy){
		logger.info("Search orders request received by controller for paidBy user : {}",paidBy);
		
		List<OrdersInfoDTO> listOfOrdersInfoDTOs = ordersService.searchOrders(paidBy);
		if(listOfOrdersInfoDTOs.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NO_CONTENT)
					.body(null);
		} else {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(listOfOrdersInfoDTOs);
		}
}
	
	
}























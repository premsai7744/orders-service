package com.myshopping.orders_service.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshopping.orders_service.DTO.OrdersInfoDTO;
import com.myshopping.orders_service.entity.OrdersInfo;
import com.myshopping.orders_service.mapper.OrdersMapper;
import com.myshopping.orders_service.repository.OrdersInfoRespository;

import jakarta.validation.Valid;

@Service
public class OrdersServiceImpl implements OrdersService{
	
	private static final Logger logger = LoggerFactory.getLogger(OrdersServiceImpl.class);
	
	@Autowired
	OrdersInfoRespository ordersInfoRespository;
	
	@Autowired
	OrdersMapper ordersMapper;
	
	@Override
	public String createOrder(@Valid OrdersInfoDTO ordersInfoDTO) {
		logger.info("Initialized createOrder execution by service class.");
		
		
		OrdersInfo ordersInfo = ordersMapper.toOrdersInfoEntity(ordersInfoDTO);
		logger.info("Mapped from ordersInfoDTO to ordersInfoEntity : ordersInfo {}",ordersInfo);
		
		OrdersInfo savedEntity = ordersInfoRespository.save(ordersInfo);
		
		if(savedEntity!=null) {
			logger.info("Order created successfully. Product details : {}",savedEntity);
			return "Order created successfully. Product details : "+savedEntity;
		} else {
			logger.info("Order creation failed. Please try again.");
			return "Order creation failed. Please try again.";
		}
	}

	@Override
	public List<OrdersInfoDTO> searchOrders(String paidBy) {
		logger.info("Initialized searchOrders execution for paidBy user : {}",paidBy);
		
		List<OrdersInfo> listOfOrdersInfos = ordersInfoRespository.searchOrdersPaidByUser(paidBy);
		
		logger.info("Searched list of orders for paid by user : listOfOrdersInfos : {}",listOfOrdersInfos);
		
		List<OrdersInfoDTO> listOfOrdersInfoDTOs = ordersMapper.toListOfOrdersInfoDTOs(listOfOrdersInfos);
		logger.info("converted from listOfOrdersInfos to listOfOrdersInfoDTOs : listOfOrdersInfoDTOs {}",listOfOrdersInfoDTOs);
		
		return listOfOrdersInfoDTOs;
	}
	
}

package com.myshopping.orders_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.myshopping.orders_service.DTO.OrdersInfoDTO;
import com.myshopping.orders_service.entity.OrdersInfo;

@Mapper(componentModel = "spring",uses= {PriceMapper.class,DeliveryMapper.class})
public interface OrdersMapper {
	
	@Mapping(target = "orderId", ignore=true)
	OrdersInfo toOrdersInfoEntity(OrdersInfoDTO ordersInfoDTO);
	
	OrdersInfoDTO toOrdersInfoDTO(OrdersInfo ordersInfo);
	
	@Mapping(target = "orderId", ignore=true)
	void toUpdateOrdersInfoEntity(OrdersInfoDTO ordersInfoDTO,@MappingTarget OrdersInfo ordersInfo);
}

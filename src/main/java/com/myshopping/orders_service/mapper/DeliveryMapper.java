package com.myshopping.orders_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.myshopping.orders_service.DTO.DeliveryDetailsDTO;
import com.myshopping.orders_service.entity.DeliveryDetails;

@Mapper(componentModel = "spring")
public interface DeliveryMapper{
	
	@Mapping(target="deliveryId",ignore=true)
	DeliveryDetails toDeliveryDetailsEntity(DeliveryDetailsDTO deliveryDetailsDTO);
	
	DeliveryDetailsDTO toDeliveryDetailsDTO(DeliveryDetails deliveryDetails);
	
	@Mapping(target="deliveryId",ignore=true)
	void toUpdateDeliveryDetailsEntity(DeliveryDetailsDTO deliveryDetailsDTO,@MappingTarget DeliveryDetails deliveryDetails);
}

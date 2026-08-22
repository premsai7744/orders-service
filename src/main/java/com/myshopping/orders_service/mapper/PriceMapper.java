package com.myshopping.orders_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.myshopping.orders_service.DTO.PriceDetailsDTO;
import com.myshopping.orders_service.entity.PriceDetails;

@Mapper(componentModel = "spring")
public interface PriceMapper {
	
	@Mapping(target="priceDetailsId",ignore=true)
	PriceDetails toPriceDetailsEntity(PriceDetailsDTO priceDetailsDTO);
	
	PriceDetailsDTO toPriceDetailsDTO(PriceDetails priceDetails);
	
	@Mapping(target="priceDetailsId",ignore=true)
	void toUpdatePriceDetailsEntity(PriceDetailsDTO priceDetailsDTO, @MappingTarget PriceDetails priceDetails);
}

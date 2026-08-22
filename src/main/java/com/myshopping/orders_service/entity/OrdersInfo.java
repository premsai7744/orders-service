package com.myshopping.orders_service.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="my_shopping_orders")
public class OrdersInfo {
	
	@GeneratedValue(strategy=GenerationType.UUID)
	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Id
	@Column(name = "ordr_id")
	private UUID orderId; 
	
	@Column(name = "ordr_prod_name")
	private String orderProductName; 
	
	@Column(name = "ordr_price")
	private double orderPrice; 
	
	@Column(name = "ordr_confirmed_date")
	private LocalDateTime orderConfirmedDate; 
	
	@Column(name = "ordr_deliverd_date")
	private LocalDateTime orderDeliverdDate;
	
	@OneToOne
	@JoinColumn(name="delvry_id")
	private DeliveryDetails deliveryDetails;
	
	@OneToOne
	@JoinColumn(name="price_details_id")
	private PriceDetails priceDetails;
}

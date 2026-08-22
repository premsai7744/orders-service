package com.myshopping.orders_service.entity;

import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table
@Entity(name="my_shopping_delivery_details")
public class DeliveryDetails {
	@GeneratedValue(strategy=GenerationType.UUID)
	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Id
	@Column(name="delvry_id")
	private UUID deliveryId;
	
	@Column(name="home")
	private String home;
	
	@Column(name="phone")
	private String phone;
}

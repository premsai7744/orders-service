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
@Entity
@Table(name="my_shopping_price_details")
public class PriceDetails {
	
	@GeneratedValue(strategy=GenerationType.UUID)
	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Id
	@Column(name="price_details_id")
	private UUID priceDetailsId;
	
	@Column(name="listing_price")
	private Double listingPrice;
	
	@Column(name="special_price")
	private Double specialPrice;
	
	@Column(name="total_fees")
	private Double totalFees;
	
	@Column(name="total_amount")
	private Double totalAmount;
	
	@Column(name="paid_by")
	private String paidBy;
}

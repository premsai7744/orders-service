package com.myshopping.orders_service.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myshopping.orders_service.entity.OrdersInfo;

@Repository
public interface OrdersInfoRespository extends JpaRepository<OrdersInfo, UUID>{

	@Query(value = "SELECT mso.* FROM MY_SHOPPING_ORDERS mso JOIN MY_SHOPPING_PRICE_DETAILS mspd ON mso.PRICE_DETAILS_ID = mspd.PRICE_DETAILS_ID WHERE mspd.PAID_BY = :paidByUser",nativeQuery = true)
	List<OrdersInfo> searchOrdersPaidByUser(@Param("paidByUser") String paidBy);

}

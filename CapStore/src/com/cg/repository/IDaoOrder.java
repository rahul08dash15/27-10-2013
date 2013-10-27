package com.cg.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.transaction.annotation.Transactional;

import com.cg.domain.Order;
@Repository
public interface IDaoOrder extends JpaRepository<Order,Long>{

	@Modifying
	@Transactional
	@Query("update Order o set o.orderStatus=?1 where o.orderId=?2")
	void updateOStatus(String status,Long orderId);	
}



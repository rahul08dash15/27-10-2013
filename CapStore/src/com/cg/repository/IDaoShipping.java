package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.transaction.annotation.Transactional;

import com.cg.domain.Shipping;

@Repository
public interface IDaoShipping extends JpaRepository<Shipping,Long>{

	@Modifying
	@Transactional
	@Query("update Shipping s set s.shippingStatus=?1 where s.shippingId=?2")
	void updateSStatus(String status,Long shipId);	
}

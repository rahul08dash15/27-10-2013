package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.domain.Product;
@Repository
public interface IDaoProduct extends JpaRepository<Product,String>{

	@Transactional
	@Query("select p from Product p where p.productId=(:x1)")
	Product findProduct(@Param("x1") String schemeName);
	
	@Transactional
	@Query("select p from Product p where p.productId=?")
	Product findOne(String product);
}

package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.cg.domain.Transaction;

@Repository
public interface IDaoTransaction extends JpaRepository<Transaction,Long>{
	

}

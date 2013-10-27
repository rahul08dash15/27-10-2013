
package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.domain.InvoiceDetails;
import com.cg.domain.Transaction;

@Repository
public interface IDaoInvoice extends JpaRepository<Transaction, Long> {
	
	@Transactional
	@Query("select new com.cg.domain.InvoiceDetails(t.transactionId,t.order.orderId,u.userFirstname,u.userLastname,t.transactionDate,t.productName,t.productQuantity,t.productCost) from Transaction t, Order o, User u WHERE t.order.orderId=o.orderId AND o.user.userId= u.userId AND t.transactionId=?1")
	public List<InvoiceDetails> getInvoiceDetails(Long trans_id);

}

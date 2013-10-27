package com.cg.domain;

import java.util.Date;


public class InvoiceDetails {
	
	public InvoiceDetails(long transactionId,long orderId, String userFirstname, String userLastname, Date transactionDate, String productName, long productQuantity, double productCost){
		super();
		this.transactionId=transactionId;
		this.orderId = orderId;
		this.userFirstname=userFirstname;
		this.userLastname=userLastname;
		this.transactionDate=transactionDate;
		this.productName = productName;
		this.productQuantity=productQuantity;
		this.productCost = productCost;	
	}
	
	private long transactionId;
	private long orderId;
	private String userFirstname;
	public InvoiceDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String userLastname;
	private Date transactionDate;
	private String productName;
	private long productQuantity;
	private double productCost;
	
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getUserFirstname() {
		return userFirstname;
	}
	public void setUserFirstname(String userFirstname) {
		this.userFirstname = userFirstname;
	}
	public String getUserLastname() {
		return userLastname;
	}
	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public double getProductCost() {
		return productCost;
	}
	public void setProductCost(float productCost) {
		this.productCost = productCost;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

}

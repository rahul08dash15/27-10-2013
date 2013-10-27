package com.cg.service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.domain.InvoiceDetails;
import com.cg.domain.Merchant;
import com.cg.domain.Order;
import com.cg.domain.Product;
import com.cg.domain.Shipping;
import com.cg.domain.Transaction;
import com.cg.domain.User;
import com.cg.repository.IDaoInvoice;
import com.cg.repository.IDaoOrder;
import com.cg.repository.IDaoProduct;
import com.cg.repository.IDaoShipping;
import com.cg.repository.IDaoTransaction;
import com.cg.repository.IDaoUser;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.cg.service.MessageSender;

@Service
public class ServiceClass {


	@Autowired
	private IDaoOrder ido;
	@Autowired
	private IDaoShipping ids;
	@Autowired
	private IDaoTransaction idt;
	@Autowired
	private IDaoUser idu;
	@Autowired
	private IDaoProduct idp;
	@Autowired()
	private IDaoInvoice idi;
	
/*	@Autowired
	private MessageSender sender;*/
	
	private Map invoiceDetailsMap=new HashMap<>();

	@Transactional
	public Order storeOrderDetails(HttpSession session){
		Double cartvalue=(Double)session.getAttribute("cart_value");
		String userid=(String)session.getAttribute("user_id");

		User user=new User();
		user.setUserId(userid);
		Order order=new Order();
		order.setCartValue(cartvalue);
		order.setUser(user);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal=Calendar.getInstance();
		String date=dateFormat.format(cal.getTime());	
		String d[]= date.split("/");
		int year = Integer.parseInt(d[0])-1900;		
		int month = Integer.parseInt(d[1])-1;
		int day = Integer.parseInt(d[2]);
		@SuppressWarnings("deprecation")
		Date requiredDate = new Date(year,month,day);	
		order.setOrderDate(requiredDate);

		//session.setAttribute("trans_id", 12345L);	
		order.setOrderStatus("PROCESSING");
		return ido.saveAndFlush(order);
	}

	@Transactional
	public Shipping storeShippingAddress(Order order,String address){
		Shipping shipping=new Shipping();
		shipping.setOrder(order);
		shipping.setShippingAddress(address);
		shipping.setUser(order.getUser());
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal=Calendar.getInstance();
		String date=dateFormat.format(cal.getTime());	
		String d[]= date.split("/");
		int year = Integer.parseInt(d[0])-1900;		
		int month = Integer.parseInt(d[1])-1;
		int day = Integer.parseInt(d[2]);
		int days=day+7;
		@SuppressWarnings("deprecation")
		Date deliveryDate = new Date(year,month,days);
		shipping.setShippingDate(order.getOrderDate());
		shipping.setDeliveryDate(deliveryDate);
		shipping.setOrderValue(order.getCartValue());
		shipping.setShippingStatus("UNSHIPPED");		
				
		return ids.saveAndFlush(shipping);	
	}


	@Transactional
	public Transaction storeTransactionDetails(HttpSession session,Order order,Map<String,List<Product>> map){
		Transaction transaction=new Transaction();		
		Integer productQuantity=(Integer)session.getAttribute("product_quantity");
		Long transactionId=(Long)session.getAttribute("received_trans_id");
		//String transactionStatus=(String)session.getAttribute("trans_status");

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal=Calendar.getInstance();
		String date=dateFormat.format(cal.getTime());	
		String d[]= date.split("/");
		int year = Integer.parseInt(d[0])-1900;		
		int month = Integer.parseInt(d[1])-1;
		int day = Integer.parseInt(d[2]);
		@SuppressWarnings("deprecation")
		Date transactionDate = new Date(year,month,day);
		
		String orderStatus=((String)session.getAttribute("trans_status"));
		updateOStatus(orderStatus,order.getOrderId());		

		List<Product> l1=map.get(order.getUser().getUserId());
		for(Product p:l1){
			transaction.setProduct(p);
			transaction.setOrder(order);
			transaction.setMerchant(p.getMerchant());
			transaction.setProductCost(p.getProductCost());
			transaction.setProductName(p.getProductName());			
			transaction.setProductQuantity(productQuantity);			
			transaction.setTransactionDate(transactionDate);			
			transaction.setTransactionId(transactionId);
			idt.saveAndFlush(transaction);
		}
		return transaction;
	}

	@Transactional
	public Product getProduct(String productId){
		return idp.findOne(productId);		
	}
	
	@Transactional
	public void updateOStatus(String status,Long orderId){
		 ido.updateOStatus(status, orderId);		
	}
	
	@Transactional
	public void updateSStatus(String status,Long shipId){
		ids.updateSStatus(status, shipId);		
	}

	@Transactional
	public HttpSession setSessionDetails(HttpSession session){
		session.setAttribute("cart_value", 2000d);	
		session.setAttribute("user_id", "U1234");
		session.setAttribute("product_quantity",1);
		session.setAttribute("product_id", "5678");

		String user_id=(String)session.getAttribute("user_id");		
		User user=idu.findOne(user_id);		
		session.setAttribute("fname", user.getUserFirstname());
		session.setAttribute("lname", user.getUserLastname());
		session.setAttribute("email", user.getUserEmail());	
		session.setAttribute("user_address", user.getUserAddress());


		Map<String,List<Product>> cartMap=new HashMap<String,List<Product>>();
		List<Product> list=new ArrayList<Product>();	

		String uid=user.getUserId();
		String pid=(String) session.getAttribute("product_id");		
		Product p=getProduct(pid);
		list.add(p);
		cartMap.put(uid, list);
		session.setAttribute("cartMap", cartMap);	

		return session;
	}
	@Transactional
	public Map getInvoiceDetails(long trans_id){

		List<InvoiceDetails> list=idi.getInvoiceDetails(trans_id);
		double sum=0;
		for(InvoiceDetails obj:list){
			sum=sum+obj.getProductCost();
		}
		
		invoiceDetailsMap.put("list", list);
		invoiceDetailsMap.put("sum", sum);
		return invoiceDetailsMap;
	}
	
	@Transactional
	public String doShipment(HttpSession session,Shipping shipment,Transaction transaction) {
		// TODO Auto-generated method stub
	
		String address=shipment.getShippingAddress();
		Date date=shipment.getShippingDate();
		Long id=shipment.getShippingId();
		System.out.println(id);
		ApplicationContext factory = new ClassPathXmlApplicationContext("SIBeanConfig.xml");
		MessageSender sender = (MessageSender) factory.getBean("messageSender");
		
		Map<String,Object> details=new HashMap<String,Object>();
		
		details.put("Name","Mayur");
		details.put("Phone",1231231234);
		
		sender.send(details);
		
		return rahulKaFunction(details);	
		
	}
	
	public String rahulKaFunction(Map<String, Object> details) {
		// TODO Auto-generated method stub
		System.out.println(details + "Shipment Done");		
		return "Delivered";
		
	}

	public void createPdf1(HttpServletResponse response) throws IOException{
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=\"Invoice.pdf\"");
		
		  
		  Double total=(Double) invoiceDetailsMap.get("sum");
		  String totalCost=Double.toString(total);
		  String firstName="";
		  String lastName="";
		  Long transId=(long) 0;
		  Long orderId=(long) 0;
		  String productname="";
		  Long productquantity=(long) 0;
		  Double productCost=(double) 0;
		  Date date=new Date();
		  DateFormat d= new SimpleDateFormat("dd-MM-yyyy");
		  
		  
		  
		  List<InvoiceDetails> invDetails= (List<InvoiceDetails>) invoiceDetailsMap.get("list");
		  for(InvoiceDetails iv:invDetails){
				transId= iv.getTransactionId();
				orderId=iv.getOrderId();
				firstName=iv.getUserFirstname();
				lastName=iv.getUserLastname();
				date=iv.getTransactionDate();
				break;
				}
		  String trans_id=Long.toString(transId);
		  String order_id=Long.toString(orderId);
		  String trans_date=d.format(date);
		  
		  
		  
		  Document document= new Document(PageSize.A4);
			try{
				PdfWriter.getInstance(document,response.getOutputStream());
				document.open();
				document.add(new Paragraph("CAPSTORE",FontFactory.getFont(FontFactory.COURIER, 20, Font.BOLDITALIC,	new CMYKColor(150, 500, 500, 100))));
				document.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------"));
				document.add(new Paragraph());
				document.add(new Paragraph());
				document.add(new Paragraph("Transaction Id:  "+trans_id));
				document.add(new Paragraph());
				document.add(new Paragraph("Order Id:        "+order_id));
				document.add(new Paragraph());
				document.add(new Paragraph("Order Date:      "+trans_date));
				document.add(new Paragraph());
				
				document.add(new Paragraph("Customer Name:   "+firstName+" "+lastName));
				document.add(new Paragraph());
				document.add(new Paragraph());
				document.add(new Paragraph());
				document.add(new Paragraph());
				PdfPTable t = new PdfPTable(3);
				t.setSpacingBefore(25);
				
				t.setSpacingAfter(25);
				
				PdfPCell c1 = new PdfPCell(new Phrase("Product Name"));  
				
				t.addCell(c1);
				
				PdfPCell c2 = new PdfPCell(new Phrase("Quantity"));
				
				t.addCell(c2);
				

			      PdfPCell c3 = new PdfPCell(new Phrase("Product Cost"));
			      t.addCell(c3);
			      for(InvoiceDetails iv:invDetails){
			    	  productname= iv.getProductName();
			    	  productquantity=iv.getProductQuantity();
			    	  productCost=iv.getProductCost();
			    	  String product_quantity=Long.toString(productquantity);
			    	  String product_cost=Double.toString(productCost);
			    	  t.addCell(productname);
			    	  t.addCell(product_quantity);
			    	  t.addCell(product_cost);
			    	  
			      }
			      document.add(t);
			      document.add(new Paragraph());
			      document.add(new Paragraph());
			      document.add(new Paragraph());
			      document.add(new Paragraph());
			      document.add(new Paragraph());
			      document.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------"));
			      document.add(new Paragraph());
			      document.add(new Paragraph());
			      document.add(new Paragraph());
			      document.add(new Paragraph("Total Cost:  "+totalCost));
			      document.close(); 
				
			
			}catch(DocumentException e){
				e.printStackTrace();
			} 
}

}

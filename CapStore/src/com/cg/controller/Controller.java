package com.cg.controller;
import java.io.IOException;
import java.text.ParseException;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.cg.domain.InvoiceDetails;
import com.cg.domain.Order;
import com.cg.domain.Product;
import com.cg.domain.Shipping;
import com.cg.domain.Transaction;
import com.cg.service.ServiceClass;


@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {
	@Autowired
	private ServiceClass sc;


	@RequestMapping(method=RequestMethod.GET)
	public String showHome(){
		return "CheckOut";
	}

	@RequestMapping(value="ordering",method=RequestMethod.GET)
	@Transactional
	public String getSessionDetails(ModelMap map,HttpServletRequest request){
		HttpSession session=request.getSession();
		sc.setSessionDetails(session);
		map.addAttribute("fname",session.getAttribute("fname"));
		map.addAttribute("lname",session.getAttribute("lname"));
		map.addAttribute("email",session.getAttribute("email"));
		map.addAttribute("cart_value",session.getAttribute("cart_value"));
		map.addAttribute("user_address",session.getAttribute("user_address"));	
		return "shipping";				
	}
	
	@RequestMapping(value="success",method=RequestMethod.GET)
	@Transactional
	public String goForShipment(HttpSession session,Shipping shipment,Transaction transaction){	
	String status=sc.doShipment(session, shipment,transaction);
		sc.updateSStatus(status,shipment.getShippingId());
		return "transaction";
	}

	@RequestMapping(value="address",method=RequestMethod.GET)
	@Transactional
	public String processingOrder(ModelMap m,HttpSession session,Map<String,List<Product>> cartmap,@RequestParam("txt_new_address")String address) throws ParseException{
		cartmap=(Map<String, List<Product>>) session.getAttribute("cartMap");
		session.setAttribute("ship_address", address);
		Order order=sc.storeOrderDetails(session);	
		m.addAttribute("orderId", order.getOrderId());
		m.addAttribute("Amount",order.getCartValue());
		sc.storeShippingAddress(order, address);		
		
		/*Double amt=(Double) m.get("Amount");
		Long id=(Long) m.get("orderId");
		//System.out.println(amt+" "+ id);

		RestTemplate restTemplate = new RestTemplate();
		String url="http://10.102.54.157:2010/MoneyFlush1/billamt/"+amt+"?link=10.102.54.154:4503/CapStore/success";
		String pg = restTemplate.getForObject(url, String.class);
		//System.out.println(url+" "+pg);

		session.setAttribute("received_trans_id", 12345L);
		session.setAttribute("trans_status", "SUCCESS");
		
		sc.storeTransactionDetails(session,order,cartmap);
		
		
		m.addAttribute("text", pg);
		return "billpay";*/
		//sc.storeTransactionDetails(session,order,cartmap);
		return "Success";
				
	}

	
	@RequestMapping(value="bill", method=RequestMethod.GET)
	public String generateInvoice(ModelMap map,HttpSession session){
	//Long id=(Long) session.getAttribute("trans_id");
	//Double amt=(Double) session.getAttribute("cart_value");
	Map invoicelist=sc.getInvoiceDetails(12345L);
	List<InvoiceDetails> list=(List<InvoiceDetails>) invoicelist.get("list");
	double sum=(double) invoicelist.get("sum");
	map.put("list", list);
	map.put("sum", sum);
	return "invoice";
	}

	
	@RequestMapping(value="/generatepdf",method=RequestMethod.GET)
	public String generatePdf(ModelMap map, HttpServletResponse response) throws IOException{
		sc.createPdf1(response);
		return "invoice";
	}

	
}
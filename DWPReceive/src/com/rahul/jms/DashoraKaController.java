package com.rahul.jms;

import java.util.HashMap;
import java.util.Map;

import javax.jms.Connection;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DashoraKaController {

@RequestMapping("/")	
	public String home() throws NamingException, JMSException{
	/*System.out.println("home");
	System.out.println("In home");
	ApplicationContext factory = new ClassPathXmlApplicationContext("SIBeanConfig.xml");
	MessageSender sender = (MessageSender) factory.getBean("messageSender");
	Map map = new HashMap();
	System.out.println("Calling");
	map.put("Name", "Why God Why");
	sender.send(map);*/

	
	ApplicationContext factory = new ClassPathXmlApplicationContext("SIBeanConfig.xml");
	MessageConsumer sender = (MessageConsumer) factory.getBean("messageConsumer");
	
	
	
//	Map map =	(Map) sender.receive();
//	System.out.println("received"+map.get("Name"));
	
	System.out.println("received"+sender.receive());
	
	
	
System.out.println("Call ho gaya");
		return "home";
	}


}

package com.rahul.jms;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCaller {
public static void main(String[] args) {
	ApplicationContext factory = new ClassPathXmlApplicationContext("SIBeanConfig.xml");
	MessageSender sender = (MessageSender) factory.getBean("messageSender");
	
	
	
	Map map = new HashMap();
	map.put("Name", "Why God Why");
	sender.send(map);
}
}

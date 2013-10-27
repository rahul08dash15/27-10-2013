package com.cg.service;

import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.core.NestedRuntimeException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MessageSender {
	private JmsTemplate jmstemplate;

public JmsTemplate getJmstemplate() {
	return jmstemplate;
}

public void setJmstemplate(JmsTemplate jmstemplate) {
	this.jmstemplate = jmstemplate;
}

public MessageSender(JmsTemplate jmstemplate) {
	super();
	this.jmstemplate = jmstemplate;
}
public void send( Map map) throws NestedRuntimeException  {

jmstemplate.convertAndSend("rahul to stud hai");
}

}

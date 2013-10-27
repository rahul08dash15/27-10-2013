package com.rahul.jms;

import java.util.Map;

import org.springframework.core.NestedRuntimeException;
import org.springframework.jms.core.JmsTemplate;

public class MessageConsumer {
private JmsTemplate jmstemplate;

public JmsTemplate getJmstemplate() {
	return jmstemplate;
}

public void setJmstemplate(JmsTemplate jmstemplate) {
	this.jmstemplate = jmstemplate;
}

public MessageConsumer(JmsTemplate jmstemplate) {
	super();
	this.jmstemplate = jmstemplate;
}
public Object receive() throws NestedRuntimeException  {
return jmstemplate.receiveAndConvert();
}

}

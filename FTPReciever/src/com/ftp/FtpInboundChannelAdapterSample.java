package com.ftp;
/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.core.PollableChannel;

public class FtpInboundChannelAdapterSample {



	public void runDemo() throws Exception{
		ConfigurableApplicationContext ctx =
			new ClassPathXmlApplicationContext("FtpInboundChannelAdapterSample-context.xml");

		PollableChannel ftpChannel = ctx.getBean("ftpChannel", PollableChannel.class);

		Message<?> message1 = ftpChannel.receive(2000);
	/*	Message<?> message2 = ftpChannel.receive(2000);
		Message<?> message3 = ftpChannel.receive(1000);
	*/
		System.out.println("Running");
	while(true){	
		System.out.println(message1.getPayload());				
	}
	}
public static void main(String[] args) throws Exception {
	FtpInboundChannelAdapterSample ftp1 = new FtpInboundChannelAdapterSample();
	ftp1.runDemo();
System.out.println("asdadada");
}
}

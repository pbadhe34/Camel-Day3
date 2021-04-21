package com.app;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.log4j.PropertyConfigurator;

public class RunSedaApp {

	public static void main(String[] args) throws Exception {
		PropertyConfigurator.configure("C:/Users/SONY/Desktop/camel-seda/src/main/resources/log4j.properties");
		CamelContext camelContext = new DefaultCamelContext();
		camelContext.addRoutes(new SedaEndPointRouter());
		camelContext.start();

		ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
		producerTemplate.sendBody(SedaEndPointRouter.DIRECT_START_ROUTE, "start Message");

		Thread.sleep(2000);
	}
}
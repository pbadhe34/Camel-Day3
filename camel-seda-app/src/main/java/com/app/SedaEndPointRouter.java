package com.app;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SedaEndPointRouter extends RouteBuilder {

	static Logger LOG = LoggerFactory.getLogger(SedaEndPointRouter.class);

	public static final String DIRECT_START_ROUTE = "direct:start";
	public static final String SEDA_END_ROUTE = "seda:end";

	@Override
	public void configure() throws Exception {
		from(DIRECT_START_ROUTE).routeId("SedaStartRouteId").setBody().simple("Seda Message").to(SEDA_END_ROUTE)
				.process(new Processor() {
					public void process(Exchange exchange) throws Exception {
						LOG.info("Message at Parent route completion");
					}
				});

		from(SEDA_END_ROUTE).routeId("EndRouteId").delay(12000).setBody().simple("End Message").process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				LOG.info("message after seda end route completion");
			}
		});
	}
}
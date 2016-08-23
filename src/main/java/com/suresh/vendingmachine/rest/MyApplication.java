package com.suresh.vendingmachine.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

@ApplicationPath("rest")
public class MyApplication extends ResourceConfig {

	 public MyApplication() {
	        packages("com.suresh.vendingmachine.rest");
	        // Register an instance of LoggingFilter.
	        //register(new LoggingFilter(LOGGER, true));
	        property(ServerProperties.TRACING, "ALL");
	    }
	
	 
	 
}

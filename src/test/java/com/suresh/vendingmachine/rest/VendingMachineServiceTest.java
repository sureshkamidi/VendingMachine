package com.suresh.vendingmachine.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg;
import org.junit.Test;
import org.testng.Assert;

public class VendingMachineServiceTest extends  JerseyTestNg.ContainerPerClassTest {

	@Override
	protected Application configure() {
//		return new MyApplication().getApplication();
		List<Class> classes =  new ArrayList<Class>();
		classes.add(VendingMachineService.class);
		classes.add(GsonProvider.class);
		Class[] classArray = new Class[2];
		classes.toArray(classArray);
		
		ResourceConfig config = new ResourceConfig(classArray);
		return config;
//		return ResourceConfig.forApplication(new MyApplication());
	}

	@Test
	public void test_getName() {
		Response response = target("myservices/getName").request().get();
		Map<String, String> result = new HashMap<String, String>();
		
		result.put("Name" , "My vending machine!!");
		Assert.assertEquals(response.readEntity(Map.class), result);
	}

}

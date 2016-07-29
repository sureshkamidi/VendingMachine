package com.suresh.vendingmachine.rest;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg;
import org.junit.Test;
import org.testng.Assert;

public class VendingMachineServiceTest extends  JerseyTestNg.ContainerPerClassTest {

	
	@Override
	protected Application configure() {
		return new ResourceConfig(VendingMachineService.class);
	}

	@Test
	public void test_getName() {
		Response response = target("myservices").request().get();
		Assert.assertEquals(response.readEntity(String.class), "My vending machine!!");
	}

}

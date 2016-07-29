package com.suresh.vendingmachine.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("myservices")
public class VendingMachineService {
	
	@GET
	public String getName() {
		return "My vending machine!!";
	}

}

package com.suresh.vendingmachine.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("myservices")
public class VendingMachineService {
	
	@GET
	@Path("getName")
	@Produces(MediaType.APPLICATION_JSON)
	public Map  getName() {
		Map<String, String> result = new HashMap<String, String>();
		
		result.put("Name" , "Suresh Kumar");
		return result;
	}

}

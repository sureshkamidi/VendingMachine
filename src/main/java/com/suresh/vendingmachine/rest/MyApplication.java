package com.suresh.vendingmachine.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class MyApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(VendingMachineService.class);
        return s;
	}
	

}

package com.suresh.vendingmachine;

public class Item {

	private ItemCode code;
	
	private String name;
	
	private double amount;

	public ItemCode getCode() {
		return code;
	}

	public void setCode(ItemCode code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}

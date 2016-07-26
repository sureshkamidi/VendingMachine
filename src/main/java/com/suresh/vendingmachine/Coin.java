package com.suresh.vendingmachine;

public enum Coin {
	
	PENNY(0.01), NICKEL(0.05), DIME(0.10) , QUARTER(0.25);
	
	
	private double denomination;
	
	Coin(double pDenomination) {
		denomination = pDenomination;
	}
	
	public double getDenomination() {
		return denomination;
	}

}

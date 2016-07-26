package com.suresh.vendingmachine;

import java.util.List;
import java.util.Map;

public interface VendingMachine {
	
	void insertCoins(List<Coin> pCoins);
	
	List<Coin> refund();
	
	void reset();
	
	Map<Item,List<Coin>> CollectItemAndChange(ItemCode  pItemCode) throws OutofStockException, NotPaidFullyException;
	

}

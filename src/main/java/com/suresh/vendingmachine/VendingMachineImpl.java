package com.suresh.vendingmachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachineImpl implements VendingMachine {

	private Inventory<Coin> cashInventory = new Inventory<Coin>();

	private Inventory<ItemCode> itemStock = new Inventory<ItemCode>();

	private Map<ItemCode, Item> products = new HashMap<ItemCode, Item>();

	private double insertedCash;

	public VendingMachineImpl() {
		initialize();
	}

	protected void initialize() {

		for (Coin c : Coin.values()) {
			cashInventory.put(c, 5);
		}

		for (ItemCode ic : ItemCode.values()) {
			itemStock.put(ic, 10);
		}
	}

	@Override
	public void insertCoins(List<Coin> pCoins) {
		for (Coin coin : pCoins) {
			insertedCash = insertedCash + coin.getDenomination();
			cashInventory.add(coin);
		}
	}

	@Override
	public List<Coin> refund() {
		List<Coin> refundCash = new ArrayList<Coin>();
		try {
			refundCash = getChange(insertedCash);
		} catch (NoSufficientChangeException e) {
			e.printStackTrace();
		}
		for (Coin coin : refundCash) {
			cashInventory.deduct(coin);
		}
		insertedCash = 0;
		return refundCash;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<Item, List<Coin>> CollectItemAndChange(ItemCode pItemCode)
			throws OutofStockException, NotPaidFullyException {
		if (!itemStock.hasItem(pItemCode)) {
			throw new OutofStockException();
		}

		Item item = products.get(pItemCode);

		if (!isFullyPaid(item)) {
			throw new NotPaidFullyException();
		}

		Map<Item, List<Coin>> result = new HashMap<Item, List<Coin>>();

		if (hasSufficientChangeForAmount(insertedCash)) {

			try {
				List<Coin> change = getChange(insertedCash - item.getAmount());
				result.put(item, change);
			} catch (NoSufficientChangeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return result;

		}

		return null;
	}

	private boolean isFullyPaid(Item pItem) {
		if (insertedCash >= pItem.getAmount()) {
			return true;
		}
		return false;
	}

	private boolean hasSufficientChangeForAmount(double amount) {
		boolean hasChange = true;
		try {
			getChange(amount);
		} catch (NoSufficientChangeException nsce) {
			return hasChange = false;
		}

		return hasChange;
	}

	private List<Coin> getChange(double amount) throws NoSufficientChangeException {

		List<Coin> change = Collections.emptyList();
		if (amount <= 0) {
			return change;
		}

		double balance = amount;

		while (balance > 0) {

			if (balance >= Coin.QUARTER.getDenomination() && cashInventory.hasItem(Coin.QUARTER)) {
				change.add(Coin.QUARTER);
				cashInventory.deduct(Coin.QUARTER);
				balance = balance - Coin.QUARTER.getDenomination();
				continue;
			} else if (balance >= Coin.DIME.getDenomination() && cashInventory.hasItem(Coin.DIME)) {
				change.add(Coin.DIME);
				cashInventory.deduct(Coin.DIME);
				balance = balance - Coin.DIME.getDenomination();
				continue;

			} else if (balance >= Coin.NICKEL.getDenomination() && cashInventory.hasItem(Coin.NICKEL)) {
				change.add(Coin.NICKEL);
				cashInventory.deduct(Coin.NICKEL);
				balance = balance - Coin.NICKEL.getDenomination();
				continue;

			} else if (balance >= Coin.PENNY.getDenomination() && cashInventory.hasItem(Coin.PENNY)) {
				change.add(Coin.PENNY);
				cashInventory.deduct(Coin.PENNY);
				balance = balance - Coin.PENNY.getDenomination();
				continue;
			}

			throw new NoSufficientChangeException();
		}

		return change;
	}

}

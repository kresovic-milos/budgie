package com.attozoic.main.services;

public interface ServiceEntityWithRebalances {
	public int getRebalancesCount();
	public void addRebalance();
	public void removeRebalance();
}

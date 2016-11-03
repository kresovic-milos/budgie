package com.attozoic.main.services;

public interface ServiceRebalancesCount extends ServiceEntity {
	
	public int rebalancePlus();
	public int rebalanceMinus(Long uid);
	
}

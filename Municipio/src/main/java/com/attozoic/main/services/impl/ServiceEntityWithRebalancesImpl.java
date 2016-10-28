package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntityWithRebalances;
import com.attozoic.main.services.ServiceEntityWithRebalances;

@Service
public class ServiceEntityWithRebalancesImpl implements ServiceEntityWithRebalances {

	@Autowired
	private DaoEntityWithRebalances dao;

	@Override
	public void addRebalance() {
		dao.addRebalance();		
	}

	

	


}

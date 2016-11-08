package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoActivityEconomicAccount;
import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.services.ServiceActivityEconomicAccount;

@Service
public class ServiceActivityEconomicAccountImpl extends ServiceEntityImpl implements ServiceActivityEconomicAccount {

	@Autowired
	private DaoActivityEconomicAccount daoActivityEconomicAccount;

	@Override
	public DaoEntity getDaoEntity() {
		return daoActivityEconomicAccount;
	}
	
}

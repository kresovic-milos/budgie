package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.dao.DaoProjectEconomicAccount;
import com.attozoic.main.services.ServiceProjectEconomicAccount;

@Service
public class ServiceProjectEconomicAccountImpl extends ServiceEntityImpl implements ServiceProjectEconomicAccount {

	@Autowired
	private DaoProjectEconomicAccount daoProjectEconomicAccount;

	@Override
	public DaoEntity getDaoEntity() {
		return daoProjectEconomicAccount;
	}
		
}

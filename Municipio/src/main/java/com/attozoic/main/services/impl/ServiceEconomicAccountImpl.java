package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEconomicAccount;
import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.services.ServiceEconomicAccount;

@Service
public class ServiceEconomicAccountImpl extends ServiceEntityImpl implements ServiceEconomicAccount {

	@Autowired
	private DaoEconomicAccount daoEconomicAccount;

	@Override
	public DaoEntity getDaoEntity() {
		return daoEconomicAccount;
	}
	

	
}

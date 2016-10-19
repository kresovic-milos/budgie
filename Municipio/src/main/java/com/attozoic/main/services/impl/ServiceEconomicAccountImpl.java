package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEconomicAccount;
import com.attozoic.main.model.EconomicAccount;
import com.attozoic.main.services.ServiceEconomicAccount;

@Service
public class ServiceEconomicAccountImpl implements ServiceEconomicAccount {

	@Autowired
	private DaoEconomicAccount daoEconomicAccount;
	
	@Override
	public Page<EconomicAccount> findAll() {
		return daoEconomicAccount.findAll();
	}
	
	@Override
	public EconomicAccount save(EconomicAccount economicAccount) {
		return daoEconomicAccount.save(economicAccount);
	}
	
}

package com.attozoic.main.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoActivityEconomicAccount;
import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.model.SuperEconomicAccount;
import com.attozoic.main.services.ServiceActivityEconomicAccount;

@Service
public class ServiceActivityEconomicAccountImpl extends ServiceEntityImpl implements ServiceActivityEconomicAccount {

	@Autowired
	private DaoActivityEconomicAccount daoActivityEconomicAccount;

	@Override
	public DaoEntity getDaoEntity() {
		return daoActivityEconomicAccount;
	}

	@Override
	public double get411Sum() {
		return ((DaoActivityEconomicAccount)getDaoEntity()).get411Sum();
	}

	@Override
	public double get412Sum() {
		return ((DaoActivityEconomicAccount)getDaoEntity()).get412Sum();
	}

	@Override
	public List<SuperEconomicAccount> getAllExpences() {
		return ((DaoActivityEconomicAccount)getDaoEntity()).getAllExpences();
	}

}

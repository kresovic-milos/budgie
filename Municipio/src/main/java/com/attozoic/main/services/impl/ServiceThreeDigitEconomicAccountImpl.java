package com.attozoic.main.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.dao.DaoThreeDigitEconomicAccount;
import com.attozoic.main.model.ThreeDigitEconomicAccount;
import com.attozoic.main.services.ServiceThreeDigitEconomicAccount;

@Service
public class ServiceThreeDigitEconomicAccountImpl extends ServiceEntityImpl implements ServiceThreeDigitEconomicAccount {

	@Autowired
	private DaoThreeDigitEconomicAccount daoThreeDigitEconomicAccount;
	
	@Override
	public DaoEntity getDaoEntity() {
		return daoThreeDigitEconomicAccount;
	}

	@Override
	public List<ThreeDigitEconomicAccount> getActivityThreeDigitEconomicAccounts(Long itemUid) {
		return ((DaoThreeDigitEconomicAccount)getDaoEntity()).getActivityThreeDigitEconomicAccounts(itemUid);
	}

	@Override
	public List<ThreeDigitEconomicAccount> getProjectThreeDigitEconomicAccounts(Long itemUid) {
		return ((DaoThreeDigitEconomicAccount)getDaoEntity()).getProjectThreeDigitEconomicAccounts(itemUid);
	}

}

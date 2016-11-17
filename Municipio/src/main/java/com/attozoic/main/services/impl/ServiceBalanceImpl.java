package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.dao.daoBalance.DaoBalance;
import com.attozoic.main.model.SuperFinancialSource;
import com.attozoic.main.services.ServiceBalance;

@Service
public class ServiceBalanceImpl extends ServiceEntityImpl implements ServiceBalance {

	@Autowired
	private DaoBalance daoBalanceWithQuarters;
	
	@Override
	public DaoEntity getDaoEntity() {
		return daoBalanceWithQuarters;
	}

	@Override
	public SuperFinancialSource addSuperFinancialSource(Long uid, SuperFinancialSource superFinancialSource) {
		// TODO Auto-generated method stub
		return ((DaoBalance)getDaoEntity()).addSuperFinancialSource(uid, superFinancialSource);
	}

}

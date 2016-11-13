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
	
	public SuperFinancialSource addQuarter1(Long uid, SuperFinancialSource superFinancialSource) {
		return ((DaoBalance)getDaoEntity()).addQuarter1(uid, superFinancialSource);
	}
	
	public SuperFinancialSource addQuarter2(Long uid, SuperFinancialSource superFinancialSource) {
		return ((DaoBalance)getDaoEntity()).addQuarter2(uid, superFinancialSource);
	}
	
	public SuperFinancialSource addQuarter3(Long uid, SuperFinancialSource superFinancialSource) {
		return ((DaoBalance)getDaoEntity()).addQuarter3(uid, superFinancialSource);
	}
	
	public SuperFinancialSource addQuarter4(Long uid, SuperFinancialSource superFinancialSource) {
		return ((DaoBalance)getDaoEntity()).addQuarter4(uid, superFinancialSource);
	}

}

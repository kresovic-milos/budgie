package com.attozoic.main.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.dao.daoBalance.DaoBalance;
import com.attozoic.main.model.SuperFinancialSource;
import com.attozoic.main.services.ServiceBalance;

@Service
public class ServiceBalanceImpl extends ServiceEntityImpl implements ServiceBalance {

	@Autowired
	private DaoBalance daoBalance;
	
	@Override
	public DaoEntity getDaoEntity() {
		return daoBalance;
	}

	@Override
	public SuperFinancialSource addSuperFinancialSource(Long uid, SuperFinancialSource superFinancialSource) {
		return ((DaoBalance)getDaoEntity()).addSuperFinancialSource(uid, superFinancialSource);
	}
	
	@Override
	public List<SuperFinancialSource> getFinancialSources(Long uid) {
		return ((DaoBalance) getDaoEntity()).getFinancialSources(uid);
	}

	@Override
	public double getSum2016Budget() {
		return ((DaoBalance) getDaoEntity()).getSum2016Budget();
	}

	@Override
	public double getSum2016Others() {
		return ((DaoBalance) getDaoEntity()).getSum2016Others();
	}

}

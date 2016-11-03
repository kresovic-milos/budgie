package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.dao.DaoRebalancesCount;
import com.attozoic.main.services.ServiceRebalancesCount;

@Service
public class ServiceRebalancesCountImpl extends ServiceEntityImpl implements ServiceRebalancesCount {

	@Autowired
	private DaoRebalancesCount daoRebalancesCount;
	
	@Override
	public DaoEntity getDaoEntity() {
		return daoRebalancesCount;
	}
	
	@Override
	public int rebalancePlus() {
		return ((DaoRebalancesCount)getDaoEntity()).rebalancePlus();
	}

	@Override
	public int rebalanceMinus(Long uid) {
		return ((DaoRebalancesCount)getDaoEntity()).rebalanceMinus(uid);
	}

}

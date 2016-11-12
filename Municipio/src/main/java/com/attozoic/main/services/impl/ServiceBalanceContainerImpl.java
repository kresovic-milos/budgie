package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.dao.daoBalance.DaoBalanceWithQuarters;
import com.attozoic.main.services.ServiceBalanceContainer;

@Service
public class ServiceBalanceContainerImpl extends ServiceEntityImpl implements ServiceBalanceContainer {

	@Autowired
	private DaoBalanceWithQuarters daoBalanceWithQuarters;
	
	@Override
	public DaoEntity getDaoEntity() {
		return daoBalanceWithQuarters;
	}

}

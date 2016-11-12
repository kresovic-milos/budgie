package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.dao.daoBalance.DaoBalanceText;
import com.attozoic.main.services.ServiceBalanceText;

@Service
public class ServiceBalanceTextImpl extends ServiceEntityImpl implements ServiceBalanceText {

	@Autowired
	private DaoBalanceText daoBalanceText;
	
	@Override
	public DaoEntity getDaoEntity() {
		return daoBalanceText;
	}

}

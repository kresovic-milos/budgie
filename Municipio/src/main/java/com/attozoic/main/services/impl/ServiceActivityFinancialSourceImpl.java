package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoActivityFinancialSource;
import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.services.ServiceActivityFinancialSource;

@Service
public class ServiceActivityFinancialSourceImpl extends ServiceEntityImpl implements ServiceActivityFinancialSource {

	@Autowired
	private DaoActivityFinancialSource daoActivityFinancialSource;

	@Override
	public DaoEntity getDaoEntity() {
		return daoActivityFinancialSource;
	}
	
	
	
}

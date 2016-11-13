package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.dao.DaoProjectFinancialSource;
import com.attozoic.main.services.ServiceProjectFinancialSource;

@Service
public class ServiceProjectFinancialSourceImpl extends ServiceEntityImpl implements ServiceProjectFinancialSource {

	@Autowired
	private DaoProjectFinancialSource daoProjectFinancialSource;
	
	@Override
	public DaoEntity getDaoEntity() {
		return daoProjectFinancialSource;
	}
}

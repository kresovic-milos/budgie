package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoActivityFinancialSource;
import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.services.ServiceActivityFinancialSource;

@Service
public class ServiceActivityFinancialSourceImpl implements ServiceActivityFinancialSource {

	@Autowired
	private DaoActivityFinancialSource daoActivityFinancialSource;
	
	@Override
	public Page<ActivityFinancialSource> findAll(){
		return daoActivityFinancialSource.findAll();
	}
	
	@Override
	public ActivityFinancialSource save(ActivityFinancialSource financialSource) {
		return daoActivityFinancialSource.save(financialSource);
	}
	
}

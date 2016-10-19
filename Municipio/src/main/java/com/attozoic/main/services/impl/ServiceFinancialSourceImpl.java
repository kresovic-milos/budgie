package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoFinancialSource;
import com.attozoic.main.model.FinancialSource;
import com.attozoic.main.services.ServiceFinancialSource;

@Service
public class ServiceFinancialSourceImpl implements ServiceFinancialSource {

	@Autowired
	private DaoFinancialSource daoFinancialSource;
	
	@Override
	public Page<FinancialSource> findAll(){
		return daoFinancialSource.findAll();
	}
	
	@Override
	public FinancialSource save(FinancialSource financialSource) {
		return daoFinancialSource.save(financialSource);
	}
	
}

package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoProjectFinancialSource;
import com.attozoic.main.model.ProjectFinancialSource;
import com.attozoic.main.services.ServiceProjectFinancialSource;

@Service
public class ServiceProjectFinancialSourceImpl implements ServiceProjectFinancialSource {

	@Autowired
	private DaoProjectFinancialSource daoProjectFinancialSource;
	
	@Override
	public Page<ProjectFinancialSource> findAll(){
		return daoProjectFinancialSource.findAll();
	}
	
	@Override
	public ProjectFinancialSource save(ProjectFinancialSource financialSource) {
		return daoProjectFinancialSource.save(financialSource);
	}
	
}

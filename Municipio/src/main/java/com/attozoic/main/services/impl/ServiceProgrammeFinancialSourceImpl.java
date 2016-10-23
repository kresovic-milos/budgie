package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoProgrammeFinancialSource;
import com.attozoic.main.model.ProgrammeFinancialSource;
import com.attozoic.main.services.ServiceProgrammeFinancialSource;

@Service
public class ServiceProgrammeFinancialSourceImpl implements ServiceProgrammeFinancialSource {

	@Autowired
	private DaoProgrammeFinancialSource daoProgrammeFinancialSource;
	
	@Override
	public Page<ProgrammeFinancialSource> findAll(){
		return daoProgrammeFinancialSource.findAll();
	}
	
	@Override
	public ProgrammeFinancialSource save(ProgrammeFinancialSource financialSource) {
		return daoProgrammeFinancialSource.save(financialSource);
	}
	
}

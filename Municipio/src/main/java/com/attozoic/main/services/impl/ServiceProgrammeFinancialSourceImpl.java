package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.dao.DaoProgrammeFinancialSource;
import com.attozoic.main.services.ServiceProgrammeFinancialSource;

@Service
public class ServiceProgrammeFinancialSourceImpl extends ServiceEntityImpl implements ServiceProgrammeFinancialSource {

	@Autowired
	private DaoProgrammeFinancialSource daoProgrammeFinancialSource;

	@Override
	public DaoEntity getDaoEntity() {
		return daoProgrammeFinancialSource;
	}
	
}

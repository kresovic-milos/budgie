package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryEconomicAccount;
import com.attozoic.categories.dao.DaoCategoryEntity;
import com.attozoic.categories.services.ServiceCategoryEconomicAccount;

@Service
public class ServiceCategoryEconomicAccountImpl extends ServiceCategoryEntityImpl implements ServiceCategoryEconomicAccount {

	@Autowired
	private DaoCategoryEconomicAccount daoEconomicAccount;

	@Override
	public DaoCategoryEntity getDaoCategoryEntity() {
		return daoEconomicAccount;
	}
	
}

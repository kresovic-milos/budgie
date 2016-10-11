package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryEconomicAccount;
import com.attozoic.categories.model.CategoryEconomicAccount;
import com.attozoic.categories.services.ServiceCategoryEconomicAccount;

@Service
public class ServiceCategoryEconomicAccountImpl implements ServiceCategoryEconomicAccount {

	@Autowired
	private DaoCategoryEconomicAccount daoEconomicAccount;
	
	@Override
	public Page<CategoryEconomicAccount> findAll() {
		return daoEconomicAccount.findAll();
	}
	
	@Override
	public CategoryEconomicAccount save(CategoryEconomicAccount economicAccount) {
		return daoEconomicAccount.save(economicAccount);
	}
	
}

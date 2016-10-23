package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryActivityFinancialSource;
import com.attozoic.categories.model.CategoryActivityFinancialSource;
import com.attozoic.categories.services.ServiceCategoryActivityFinancialSource;

@Service
public class ServiceCategoryActivityFinancialSourceImpl implements ServiceCategoryActivityFinancialSource {

	@Autowired
	private DaoCategoryActivityFinancialSource daoActivityFinancialSource;
	
	@Override
	public Page<CategoryActivityFinancialSource> findAll(){
		return daoActivityFinancialSource.findAll();
	}
	
	@Override
	public CategoryActivityFinancialSource save(CategoryActivityFinancialSource financialSource) {
		return daoActivityFinancialSource.save(financialSource);
	}
	
}

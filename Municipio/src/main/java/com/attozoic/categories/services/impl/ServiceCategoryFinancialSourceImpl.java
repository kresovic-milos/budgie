package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryFinancialSource;
import com.attozoic.categories.model.CategoryFinancialSource;
import com.attozoic.categories.services.ServiceCategoryFinancialSource;

@Service
public class ServiceCategoryFinancialSourceImpl implements ServiceCategoryFinancialSource {

	@Autowired
	private DaoCategoryFinancialSource daoFinancialSource;
	
	@Override
	public Page<CategoryFinancialSource> findAll(){
		return daoFinancialSource.findAll();
	}
	
	@Override
	public CategoryFinancialSource save(CategoryFinancialSource financialSource) {
		return daoFinancialSource.save(financialSource);
	}
	
}

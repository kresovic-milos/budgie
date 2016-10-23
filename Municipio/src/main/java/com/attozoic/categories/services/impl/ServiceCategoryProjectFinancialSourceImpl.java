package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryProjectFinancialSource;
import com.attozoic.categories.model.CategoryProjectFinancialSource;
import com.attozoic.categories.services.ServiceCategoryProjectFinancialSource;

@Service
public class ServiceCategoryProjectFinancialSourceImpl implements ServiceCategoryProjectFinancialSource {

	@Autowired
	private DaoCategoryProjectFinancialSource daoProjectFinancialSource;
	
	@Override
	public Page<CategoryProjectFinancialSource> findAll(){
		return daoProjectFinancialSource.findAll();
	}
	
	@Override
	public CategoryProjectFinancialSource save(CategoryProjectFinancialSource financialSource) {
		return daoProjectFinancialSource.save(financialSource);
	}
	
}

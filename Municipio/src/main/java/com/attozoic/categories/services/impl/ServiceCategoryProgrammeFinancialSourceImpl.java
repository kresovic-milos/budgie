package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryProgrammeFinancialSource;
import com.attozoic.categories.model.CategoryProgrammeFinancialSource;
import com.attozoic.categories.services.ServiceCategoryProgrammeFinancialSource;

@Service
public class ServiceCategoryProgrammeFinancialSourceImpl implements ServiceCategoryProgrammeFinancialSource {

	@Autowired
	private DaoCategoryProgrammeFinancialSource daoProgrammeFinancialSource;
	
	@Override
	public Page<CategoryProgrammeFinancialSource> findAll(){
		return daoProgrammeFinancialSource.findAll();
	}
	
	@Override
	public CategoryProgrammeFinancialSource save(CategoryProgrammeFinancialSource financialSource) {
		return daoProgrammeFinancialSource.save(financialSource);
	}
	
}

package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryEntity;
import com.attozoic.categories.dao.DaoCategoryFinancialSource;
import com.attozoic.categories.services.ServiceCategoryFinancialSource;

@Service
public class ServiceCategoryFinancialSourceImpl extends ServiceCategoryEntityImpl implements ServiceCategoryFinancialSource {

	@Autowired
	private DaoCategoryFinancialSource daoCategoryFinancialSource;

	@Override
	public DaoCategoryEntity getDaoCategoryEntity() {
		return daoCategoryFinancialSource;
	}
	
}

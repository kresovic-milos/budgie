package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryEntity;
import com.attozoic.categories.dao.DaoCategoryFunction;
import com.attozoic.categories.services.ServiceCategoryFunction;

@Service
public class ServiceCategoryFunctionImpl extends ServiceCategoryEntityImpl implements ServiceCategoryFunction {

	@Autowired
	DaoCategoryFunction daoFunction;

	@Override
	public DaoCategoryEntity getDaoCategoryEntity() {
		return daoFunction;
	}

}

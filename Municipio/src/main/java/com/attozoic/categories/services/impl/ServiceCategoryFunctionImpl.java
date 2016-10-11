package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryFunction;
import com.attozoic.categories.model.CategoryFunction;
import com.attozoic.categories.services.ServiceCategoryFunction;

@Service
public class ServiceCategoryFunctionImpl implements ServiceCategoryFunction {

	@Autowired
	DaoCategoryFunction daoFunction;

	@Override
	public Page<CategoryFunction> findAll() {
		return daoFunction.findAll();
	}

	@Override
	public CategoryFunction save(CategoryFunction function) {
		return daoFunction.save(function);
	}
}

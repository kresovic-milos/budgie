package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryActivity;
import com.attozoic.categories.model.CategoryActivity;
import com.attozoic.categories.services.ServiceCategoryActivity;

@Service
public class ServiceCategoryActivityImpl implements ServiceCategoryActivity {

	@Autowired
	DaoCategoryActivity daoActivity;
	
	@Override
	public Page<CategoryActivity> findAll() {
		return daoActivity.findAll(); 
	}

	@Override
	public CategoryActivity save(CategoryActivity activity) {
		return daoActivity.save(activity);
	}
	
	

}

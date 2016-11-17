package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryBook;
import com.attozoic.categories.dao.DaoCategoryEntity;
import com.attozoic.categories.services.ServiceCategoryBook;

@Service
public class ServiceCategoryBookImpl extends ServiceCategoryEntityImpl implements ServiceCategoryBook {

	@Autowired
	private DaoCategoryBook daoCategoryBook;
	
	@Override
	public DaoCategoryEntity getDaoCategoryEntity() {
		return daoCategoryBook;
	}
	
}

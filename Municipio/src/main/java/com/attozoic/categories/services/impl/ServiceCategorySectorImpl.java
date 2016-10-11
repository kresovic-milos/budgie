package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategorySector;
import com.attozoic.categories.model.CategorySector;
import com.attozoic.categories.services.ServiceCategorySector;

@Service
public class ServiceCategorySectorImpl implements ServiceCategorySector {

	@Autowired
	private DaoCategorySector daoSector;
	
	@Override
	public Page<CategorySector> findAll() {
		return daoSector.findAll();
	}

	@Override
	public CategorySector save(CategorySector sector) {
		return daoSector.save(sector);
	}
	
}

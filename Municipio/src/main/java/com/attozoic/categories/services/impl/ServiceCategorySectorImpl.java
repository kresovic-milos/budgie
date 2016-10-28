package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryEntity;
import com.attozoic.categories.dao.DaoCategorySector;
import com.attozoic.categories.model.CategoryProgramme;
import com.attozoic.categories.services.ServiceCategorySector;

@Service
public class ServiceCategorySectorImpl extends ServiceCategoryEntityImpl implements ServiceCategorySector {

	@Autowired
	private DaoCategorySector daoSector;

	@Override
	public DaoCategoryEntity getDaoCategoryEntity() {
		return daoSector;
	}
	
	@Override
	public CategoryProgramme addCategoryProgramme(Long uid, CategoryProgramme categoryProgramme) {
		return ((DaoCategorySector)getDaoCategoryEntity()).addCategoryProgramme(uid, categoryProgramme);
	}


	

	
}

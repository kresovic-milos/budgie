package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryProgramme;
import com.attozoic.categories.model.CategoryProgramme;
import com.attozoic.categories.services.ServiceCategoryProgramme;

@Service
public class ServiceCategoryProgrammeImpl implements ServiceCategoryProgramme {

	@Autowired
	private DaoCategoryProgramme daoProgramme;

	@Override
	public Page<CategoryProgramme> findAll() {
		return daoProgramme.findAll();
	}

	@Override
	public CategoryProgramme save(CategoryProgramme programme) {
		return daoProgramme.save(programme);
	}
	
}
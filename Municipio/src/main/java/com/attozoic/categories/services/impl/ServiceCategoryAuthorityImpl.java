package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryAuthority;
import com.attozoic.categories.dao.DaoCategoryEntity;
import com.attozoic.categories.services.ServiceCategoryAuthority;
import com.attozoic.categories.services.impl.ServiceCategoryEntityImpl;

@Service
public class ServiceCategoryAuthorityImpl extends ServiceCategoryEntityImpl implements ServiceCategoryAuthority {

	@Autowired
	private DaoCategoryAuthority daoCategoryAuthority;
	
	@Override
	public DaoCategoryEntity getDaoCategoryEntity() {
		return daoCategoryAuthority;
	}
	
}

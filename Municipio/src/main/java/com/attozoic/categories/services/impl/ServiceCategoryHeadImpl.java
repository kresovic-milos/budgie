package com.attozoic.categories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.categories.dao.DaoCategoryEntity;
import com.attozoic.categories.dao.DaoCategoryHead;
import com.attozoic.categories.services.ServiceCategoryHead;

@Service
public class ServiceCategoryHeadImpl extends ServiceCategoryEntityImpl implements ServiceCategoryHead {

	@Autowired
	private DaoCategoryHead daoCategoryHead;
	
	@Override
	public DaoCategoryEntity getDaoCategoryEntity() {
		return daoCategoryHead;
	}

}

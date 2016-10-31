package com.attozoic.categories.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.repositories.RepositoryCategoryEntity;
import com.attozoic.categories.repositories.RepositoryCategoryHead;

@Repository
public class DaoCategoryHead extends DaoCategoryEntity {

	@Autowired
	private RepositoryCategoryHead repoCategoryHead;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryCategoryEntity getCategoryRepoEntity() {
		return repoCategoryHead;
	}

}

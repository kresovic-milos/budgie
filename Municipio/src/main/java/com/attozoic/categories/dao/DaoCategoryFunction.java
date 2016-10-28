package com.attozoic.categories.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.repositories.RepositoryCategoryEntity;
import com.attozoic.categories.repositories.RepositoryCategoryFunction;

@Repository
public class DaoCategoryFunction extends DaoCategoryEntity {
	
	@Autowired
	private RepositoryCategoryFunction repoFunction;

	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryCategoryEntity getCategoryRepoEntity() {
		return repoFunction;
	}

}

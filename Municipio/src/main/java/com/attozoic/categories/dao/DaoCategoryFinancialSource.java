package com.attozoic.categories.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.repositories.RepositoryCategoryEntity;
import com.attozoic.categories.repositories.RepositoryCategoryFinancialSource;

@Repository
public class DaoCategoryFinancialSource extends DaoCategoryEntity {

	@Autowired
	private RepositoryCategoryFinancialSource repoFinancialSources;

	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryCategoryEntity getCategoryRepoEntity() {
		return repoFinancialSources;
	}
	
}

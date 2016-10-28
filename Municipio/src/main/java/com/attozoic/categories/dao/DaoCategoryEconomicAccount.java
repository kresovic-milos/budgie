package com.attozoic.categories.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.repositories.RepositoryCategoryEconomicAccount;
import com.attozoic.categories.repositories.RepositoryCategoryEntity;

@Repository
public class DaoCategoryEconomicAccount extends DaoCategoryEntity {

	@Autowired
	private RepositoryCategoryEconomicAccount repoEconomicAccount;

	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryCategoryEntity getCategoryRepoEntity() {
		return repoEconomicAccount;
	}
	
}

package com.attozoic.categories.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryEconomicAccount;
import com.attozoic.categories.repositories.RepositoryCategoryEconomicAccount;

@Repository
public class DaoCategoryEconomicAccount {

	@Autowired
	private RepositoryCategoryEconomicAccount repoEconomicAccount;
	
	public Page<CategoryEconomicAccount> findAll() {
		Page<CategoryEconomicAccount> page = new PageImpl<>(repoEconomicAccount.findAll());
		return page;
	}
	
	public CategoryEconomicAccount save(CategoryEconomicAccount economicAccount) {
		return repoEconomicAccount.save(economicAccount);
	}
	
}

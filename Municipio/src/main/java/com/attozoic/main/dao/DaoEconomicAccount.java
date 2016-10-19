package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.EconomicAccount;
import com.attozoic.main.repositories.RepositoryEconomicAccount;

@Repository
public class DaoEconomicAccount {

	@Autowired
	private RepositoryEconomicAccount repoEconomicAccount;
	
	public Page<EconomicAccount> findAll() {
		Page<EconomicAccount> page = new PageImpl<>(repoEconomicAccount.findAll());
		return page;
	}
	
	public EconomicAccount save(EconomicAccount economicAccount) {
		return repoEconomicAccount.save(economicAccount);
	}
	
}

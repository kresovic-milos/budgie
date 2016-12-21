package com.attozoic.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ThreeDigitEconomicAccount;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryThreeDigitEconomicAccount;

@Repository
public class DaoThreeDigitEconomicAccount extends DaoEntity {

	@Autowired
	private RepositoryThreeDigitEconomicAccount repoThreeDigitEconomicAccount;

	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoThreeDigitEconomicAccount;
	}
	
	public List<ThreeDigitEconomicAccount> getActivityThreeDigitEconomicAccounts(Long itemUid) {
		return ((RepositoryThreeDigitEconomicAccount)getRepoEntity()).getActivityThreeDigitEconomicAccounts(itemUid);
	}

	public List<ThreeDigitEconomicAccount> getProjectThreeDigitEconomicAccounts(Long itemUid) {
		return ((RepositoryThreeDigitEconomicAccount)getRepoEntity()).getProjectThreeDigitEconomicAccounts(itemUid);
	}
	
}

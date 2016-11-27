package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.repositories.RepositoryActivityEconomicAccount;
import com.attozoic.main.repositories.RepositoryEntity;

@Repository
public class DaoActivityEconomicAccount extends DaoEntity {

	@Autowired
	private RepositoryActivityEconomicAccount repoActivityEconomicAccount;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoActivityEconomicAccount;
	}
	
//	public List<DtoBalanceFinancialSourceObject> getActivityEconomicAccountDtoBalanceFinancialSourceObjectLists(Long uid) {
//		ActivityEconomicAccount activityEconomicAccount = (ActivityEconomicAccount)getRepoEntity().findOne(uid);
//		return activityEconomicAccount.generateActivityEconomicAccountDtoBalanceFinancialSourceObjectLists();
//	}
		
}

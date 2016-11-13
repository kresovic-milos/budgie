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
	
//	@Override
//	public SuperEntity update(SuperEntity superEntity) {
//		// Uzmes broj rebalansa pa tako
//		ActivityEconomicAccount activityEconomicAccount = (ActivityEconomicAccount) superEntity;
//		activityEconomicAccount.setSumExpenses123Budget(activityEconomicAccount.sumExpenses123Budget());
//		activityEconomicAccount.setSumExpenses123Others(activityEconomicAccount.sumExpenses123Others());
//		List<BalanceContainer> balanceContainers = activityEconomicAccount.getBalanceContainers();
//		BalanceContainer balanceContainer = balanceContainers.get(1);
//		List<BalanceEconomicAccount> accounts = balanceContainer.getBalances();
//		Balance bwq = (Balance)accounts.get(1);
//		bwq.sumQuarters(); //SETUJ
//		return super.update(activityEconomicAccount);
//	}
		
}

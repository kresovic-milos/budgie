package com.attozoic.main.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.model.balance.BalanceContainer;
import com.attozoic.main.model.balance.BalanceEconomicAccount;
import com.attozoic.main.model.balance.BalanceWithQuarters;
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
	
	@Override
	public SuperEntity update(SuperEntity superEntity) {
		// Uzmes broj rebalansa pa tako
		ActivityEconomicAccount activityEconomicAccount = (ActivityEconomicAccount) superEntity;
		activityEconomicAccount.setSumExpenses123Budget(activityEconomicAccount.sumExpenses123Budget());
		activityEconomicAccount.setSumExpenses123Others(activityEconomicAccount.sumExpenses123Others());
		List<BalanceContainer> balanceContainers = activityEconomicAccount.getBalanceContainers();
		BalanceContainer balanceContainer = balanceContainers.get(1);
		List<BalanceEconomicAccount> accounts = balanceContainer.getBalances();
		BalanceWithQuarters bwq = (BalanceWithQuarters)accounts.get(1);
		bwq.sumQuarters(); //SETUJ
		return super.update(activityEconomicAccount);
	}
		
}

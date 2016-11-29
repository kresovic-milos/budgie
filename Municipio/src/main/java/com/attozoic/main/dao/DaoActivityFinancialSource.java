package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.model.balance.Balance;
import com.attozoic.main.repositories.RepositoryActivityEconomicAccount;
import com.attozoic.main.repositories.RepositoryActivityFinancialSource;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.repositoriesBalance.RepositoryBalance;

@Repository
public class DaoActivityFinancialSource extends DaoEntity {

	@Autowired
	private RepositoryActivityFinancialSource repoActivityFinancialSource;
	
	@Autowired
	private RepositoryActivityEconomicAccount repoActivityEconomicAccount;
	
	@Autowired
	private RepositoryBalance repoBalance;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoActivityFinancialSource;
	}
	
	@Override
	public SuperEntity update(SuperEntity superEntity) {
		ActivityFinancialSource activityFinancialSource = (ActivityFinancialSource) superEntity;
		activityFinancialSource.generateFinancialSourceAmount();
		SuperEntity afs = super.update(activityFinancialSource);
		ActivityFinancialSource afs1 = (ActivityFinancialSource) afs;
		Balance balance = repoBalance.findOne(afs1.getBalance().getUid());
		balance.generateBalanceAmount();
		repoBalance.save(balance);
		ActivityEconomicAccount activityEconomicAccount = repoActivityEconomicAccount.findOne(balance.getSuperEconomicAccount().getUid()); 
		activityEconomicAccount.generateSumExpences123();
		repoActivityEconomicAccount.save(activityEconomicAccount);
		return afs;
	}
	
	@Override
	public void archive(Long uid) {
		ActivityFinancialSource activityFinancialSource = repoActivityFinancialSource.findOne(uid);
		Balance balance = repoBalance.findOne(activityFinancialSource.getBalance().getUid());
		//repoBalance.updateBalanceAmount((activityFinancialSource.getBalance().getBalance_amount() - activityFinancialSource.getAmount()), uid);
		super.archive(uid);
		
		balance.generateBalanceAmount();
		Balance b = repoBalance.save(balance);
		ActivityEconomicAccount aea = repoActivityEconomicAccount.findOne(b.getSuperEconomicAccount().getUid());
		aea.generateSumExpences123();
		//repoBalance.save(balance);
		repoActivityEconomicAccount.save(aea);
		//super.archive(uid);
	}
	
}

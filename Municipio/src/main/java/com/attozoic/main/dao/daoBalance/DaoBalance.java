package com.attozoic.main.dao.daoBalance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ProjectEconomicAccount;
import com.attozoic.main.model.SuperEconomicAccount;
import com.attozoic.main.model.SuperFinancialSource;
import com.attozoic.main.model.balance.Balance;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.repositoriesBalance.RepositoryBalance;

@Repository
public class DaoBalance extends DaoEntity {

	@Autowired
	private RepositoryBalance repoBalance;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoBalance;
	}
	
	// Add SuperFinancialSource to Balance
	@SuppressWarnings("unchecked")
	public SuperFinancialSource addSuperFinancialSource(Long uid, SuperFinancialSource superFinancialSource) {
		Balance balance = (Balance)getRepoEntity().findOne(uid);
		List<SuperFinancialSource> superFinancialSources = balance.getFinancialSources();
		superFinancialSources.add(superFinancialSource);
		balance.setFinancialSources(superFinancialSources);
		balance.generateBalanceAmount();
		SuperEconomicAccount superEconomicAccount = balance.getSuperEconomicAccount(); 
		if (superEconomicAccount instanceof ActivityEconomicAccount) {
			((ActivityEconomicAccount)superEconomicAccount).generateSumExpences123();
		} else {
			((ProjectEconomicAccount)superEconomicAccount).generateSumExpences123();
		}
		superFinancialSource.setBalance(balance);
		superFinancialSource.setYear(balance.getYear());
		return (SuperFinancialSource) getRepoEntity().save(superFinancialSource);
	}
	
}

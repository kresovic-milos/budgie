package com.attozoic.main.dao.daoBalance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.dao.DaoEntity;
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
	
	// Add FinancialSource_quarter1 to Balance
	@SuppressWarnings("unchecked")
	public SuperFinancialSource addQuarter1(Long uid, SuperFinancialSource superFinancialSource) {
		Balance balance_q1 = (Balance) getRepoEntity().findOne(uid);
		superFinancialSource.setBalance_q1(balance_q1);
		return (SuperFinancialSource) getRepoEntity().save(superFinancialSource);
	}
	
	// Add FinancialSource_quarter2 to Balance
	@SuppressWarnings("unchecked")
	public SuperFinancialSource addQuarter2(Long uid, SuperFinancialSource superFinancialSource) {
		Balance balance_q2 = (Balance) getRepoEntity().findOne(uid);
		superFinancialSource.setBalance_q2(balance_q2);
		return (SuperFinancialSource) getRepoEntity().save(superFinancialSource);
	}
	
	// Add FinancialSource_quarter3 to Balance
	@SuppressWarnings("unchecked")
	public SuperFinancialSource addQuarter3(Long uid, SuperFinancialSource superFinancialSource) {
		Balance balance_q3 = (Balance) getRepoEntity().findOne(uid);
		superFinancialSource.setBalance_q3(balance_q3);
		return (SuperFinancialSource) getRepoEntity().save(superFinancialSource);
	}
	
	// Add FinancialSource_quarter1 to Balance
	@SuppressWarnings("unchecked")
	public SuperFinancialSource addQuarter4(Long uid, SuperFinancialSource superFinancialSource) {
		Balance balance_q4 = (Balance) getRepoEntity().findOne(uid);
		superFinancialSource.setBalance_q4(balance_q4);
		return (SuperFinancialSource) getRepoEntity().save(superFinancialSource);
	}
	
}

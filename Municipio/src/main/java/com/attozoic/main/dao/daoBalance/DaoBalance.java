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
	
	// Add FinancialSource_quarter1 to Balance
	@SuppressWarnings("unchecked")
	public SuperFinancialSource addQuarter1(Long uid, SuperFinancialSource superFinancialSource) {
		Balance balance_q1 = (Balance) getRepoEntity().findOne(uid);
		List<SuperFinancialSource> list_q1 = balance_q1.getQuarter1();
		list_q1.add(superFinancialSource);
		balance_q1.setQuarter1(list_q1);
		balance_q1.generateQuarter1AmountValue();
		balance_q1.generateBalanceAmountValue();
		SuperEconomicAccount superEconomicAccount = balance_q1.getSuperEconomicAccount(); 
		if (superEconomicAccount instanceof ActivityEconomicAccount) {
			//System.out.println("Im Activity");
			((ActivityEconomicAccount)superEconomicAccount).sumExpences123();
		} else {
			//System.out.println("Im Project");
			((ProjectEconomicAccount)superEconomicAccount).sumExpences123();
		}
		superFinancialSource.setBalance_q1(balance_q1);
		
		return (SuperFinancialSource) getRepoEntity().save(superFinancialSource);
	}
	
	// Add FinancialSource_quarter2 to Balance
	@SuppressWarnings("unchecked")
	public SuperFinancialSource addQuarter2(Long uid, SuperFinancialSource superFinancialSource) {
		Balance balance_q2 = (Balance) getRepoEntity().findOne(uid);
		List<SuperFinancialSource> list_q2 = balance_q2.getQuarter2();
		list_q2.add(superFinancialSource);
		balance_q2.setQuarter2(list_q2);
		balance_q2.generateQuarter2AmountValue();
		balance_q2.generateBalanceAmountValue();
		SuperEconomicAccount superEconomicAccount = balance_q2.getSuperEconomicAccount(); 
		if (superEconomicAccount instanceof ActivityEconomicAccount) {
			System.out.println("Ja sam aktivnost");
			((ActivityEconomicAccount)superEconomicAccount).sumExpences123();
		} else {
			System.out.println("Ja sam projekat");
			((ProjectEconomicAccount)superEconomicAccount).sumExpences123();
		}
		superFinancialSource.setBalance_q2(balance_q2);
		return (SuperFinancialSource) getRepoEntity().save(superFinancialSource);
	}
	
	// Add FinancialSource_quarter3 to Balance
	@SuppressWarnings("unchecked")
	public SuperFinancialSource addQuarter3(Long uid, SuperFinancialSource superFinancialSource) {
		Balance balance_q3 = (Balance) getRepoEntity().findOne(uid);
		List<SuperFinancialSource> list_q3 = balance_q3.getQuarter3();
		list_q3.add(superFinancialSource);
		balance_q3.setQuarter3(list_q3);
		balance_q3.generateQuarter3AmountValue();
		balance_q3.generateBalanceAmountValue();
		SuperEconomicAccount superEconomicAccount = balance_q3.getSuperEconomicAccount(); 
		if (superEconomicAccount instanceof ActivityEconomicAccount) {
			System.out.println("Ja sam aktivnost");
			((ActivityEconomicAccount)superEconomicAccount).sumExpences123();
		} else {
			System.out.println("Ja sam projekat");
			((ProjectEconomicAccount)superEconomicAccount).sumExpences123();
		}
		superFinancialSource.setBalance_q3(balance_q3);
		return (SuperFinancialSource) getRepoEntity().save(superFinancialSource);
	}
	
	// Add FinancialSource_quarter4 to Balance
	@SuppressWarnings("unchecked")
	public SuperFinancialSource addQuarter4(Long uid, SuperFinancialSource superFinancialSource) {
		Balance balance_q4 = (Balance) getRepoEntity().findOne(uid);
		List<SuperFinancialSource> list_q4 = balance_q4.getQuarter4();
		list_q4.add(superFinancialSource);
		balance_q4.setQuarter4(list_q4);
		balance_q4.generateQuarter4AmountValue();
		balance_q4.generateBalanceAmountValue();
		SuperEconomicAccount superEconomicAccount = balance_q4.getSuperEconomicAccount(); 
		if (superEconomicAccount instanceof ActivityEconomicAccount) {
			System.out.println("Ja sam aktivnost");
			((ActivityEconomicAccount)superEconomicAccount).sumExpences123();
		} else {
			System.out.println("Ja sam projekat");
			((ProjectEconomicAccount)superEconomicAccount).sumExpences123();
		}
		superFinancialSource.setBalance_q4(balance_q4);
		return (SuperFinancialSource) getRepoEntity().save(superFinancialSource);
	}
	
}

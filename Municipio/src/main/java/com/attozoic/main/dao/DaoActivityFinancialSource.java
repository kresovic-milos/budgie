package com.attozoic.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.model.SuperFinancialSource;
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
	private RepositoryBalance repoBalance;
	
	@Autowired
	private RepositoryActivityEconomicAccount repoActivityEconomicAccount;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoActivityFinancialSource;
	}
	
	@Override
	public SuperEntity update(SuperEntity superEntity) {
		ActivityFinancialSource activityFinancialSource = (ActivityFinancialSource) superEntity;
		Balance balance = new Balance();
		if (activityFinancialSource.getBalance_q1() != null) {
			balance = repoBalance.findOne(activityFinancialSource.getBalance_q1().getUid());
			List<SuperFinancialSource> list_q1 = balance.getQuarter1();
			for (int i = 0; i < list_q1.size(); i++) {
				if (list_q1.get(i).getUid() == activityFinancialSource.getUid()) {
					list_q1.set(i, activityFinancialSource);
				}
			}
			balance.setQuarter1(list_q1);
			balance.setQuarter1_amount(balance.generateQuarterAmountValue(list_q1));
		} else if (activityFinancialSource.getBalance_q2() != null) {
			balance = repoBalance.findOne(activityFinancialSource.getBalance_q2().getUid());
			List<SuperFinancialSource> list_q2 = balance.getQuarter2();
			for (int i = 0; i < list_q2.size(); i++) {
				if (list_q2.get(i).getUid() == activityFinancialSource.getUid()) {
					list_q2.set(i, activityFinancialSource);
				}				
			}
			balance.setQuarter2(list_q2);
			balance.setQuarter2_amount(balance.generateQuarterAmountValue(list_q2));
		} else if ((activityFinancialSource.getBalance_q3() != null)) {
			balance = repoBalance.findOne(activityFinancialSource.getBalance_q3().getUid());
			List<SuperFinancialSource> list_q3 = balance.getQuarter3();
			for (int i = 0; i < list_q3.size(); i++) {
				if (list_q3.get(i).getUid() == activityFinancialSource.getUid()) {
					list_q3.set(i, activityFinancialSource);
				}				
			}
			balance.setQuarter3(list_q3);
			balance.setQuarter3_amount(balance.generateQuarterAmountValue(list_q3));
		} else if ((activityFinancialSource.getBalance_q4() != null)) {
			balance = repoBalance.findOne(activityFinancialSource.getBalance_q4().getUid());
			List<SuperFinancialSource> list_q4 = balance.getQuarter4();
			for (int i = 0; i < list_q4.size(); i++) {
				if (list_q4.get(i).getUid() == activityFinancialSource.getUid()) {
					list_q4.set(i, activityFinancialSource);
				}				
			}
			balance.setQuarter4(list_q4);
			balance.setQuarter4_amount(balance.generateQuarterAmountValue(list_q4));
		}
		balance.setBalance_amount(balance.generateAmountValue());
		ActivityEconomicAccount activityEconomicAccount = repoActivityEconomicAccount.findOne(balance.getSuperEconomicAccount().getUid()); 
		activityEconomicAccount.sumExpences123();
		//repoBalance.save(balance);
		//repoActivityEconomicAccount.save(activityEconomicAccount);
		return super.update(superEntity);
	}
	
}

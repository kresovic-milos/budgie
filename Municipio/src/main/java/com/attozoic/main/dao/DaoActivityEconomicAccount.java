package com.attozoic.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.RebalanceTwoFields;
import com.attozoic.main.model.RebalancesCount;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.repositories.RepositoryActivityEconomicAccount;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryRebalancesCount;

@Repository
public class DaoActivityEconomicAccount extends DaoEntity {

	@Autowired
	private RepositoryActivityEconomicAccount repoActivityEconomicAccount;

	@Autowired
	private RepositoryRebalancesCount repoRebalanceCount;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoActivityEconomicAccount;
	}
	
	@Override
	public SuperEntity update(SuperEntity superEntity) {
		ActivityEconomicAccount activityEconomicAccount = (ActivityEconomicAccount) superEntity;
		activityEconomicAccount.setSumExpenses123Budget(activityEconomicAccount.getExpenseBaseYearPlus1Budget1() + activityEconomicAccount.getExpenseBaseYearPlus1Budget2() + activityEconomicAccount.getExpenseBaseYearPlus1Budget3() + activityEconomicAccount.getExpenseBaseYearPlus1Budget4() + activityEconomicAccount.getExpenseBaseYearPlus2Budget() + activityEconomicAccount.getExpenseBaseYearPlus3Budget());
		activityEconomicAccount.setSumExpenses123Others(activityEconomicAccount.getExpenseBaseYearPlus1Others1() + activityEconomicAccount.getExpenseBaseYearPlus1Others2() + activityEconomicAccount.getExpenseBaseYearPlus1Others3() + activityEconomicAccount.getExpenseBaseYearPlus1Others4() + activityEconomicAccount.getExpenseBaseYearPlus2Others() + activityEconomicAccount.getExpenseBaseYearPlus3Others());
		activityEconomicAccount.setSumExpensesBaseYearPlus1Budget(activityEconomicAccount.getExpenseBaseYearPlus1Budget1() + activityEconomicAccount.getExpenseBaseYearPlus1Budget2() + activityEconomicAccount.getExpenseBaseYearPlus1Budget3() + activityEconomicAccount.getExpenseBaseYearPlus1Budget4());
		activityEconomicAccount.setSumExpensesBaseYearPlus1Others(activityEconomicAccount.getExpenseBaseYearPlus1Others1() + activityEconomicAccount.getExpenseBaseYearPlus1Others2() + activityEconomicAccount.getExpenseBaseYearPlus1Others3() + activityEconomicAccount.getExpenseBaseYearPlus1Others4());
		try {
			RebalancesCount rc = repoRebalanceCount.findOne(new Long(1));
			int numReb = rc.getRebalancesCount();
			if (numReb > 0) {
				List<RebalanceTwoFields> l = activityEconomicAccount.getRebalances();
				for (int i = 0; i < l.size(); i++) {
					l.get(i).setSumValueB(l.get(i).sumValueBudget());
					l.get(i).setSumValueO(l.get(i).sumValueOthers());
				}
				activityEconomicAccount.setRebalances(l);
			}
		} catch (NullPointerException ex) {}
		return super.update(activityEconomicAccount);
	}
	
}

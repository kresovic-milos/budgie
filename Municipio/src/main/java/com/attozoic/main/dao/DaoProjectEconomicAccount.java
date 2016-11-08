package com.attozoic.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProjectEconomicAccount;
import com.attozoic.main.model.RebalanceTwoFields;
import com.attozoic.main.model.RebalancesCount;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProjectEconomicAccount;
import com.attozoic.main.repositories.RepositoryRebalancesCount;

@Repository
public class DaoProjectEconomicAccount extends DaoEntity {

	@Autowired
	private RepositoryProjectEconomicAccount repoProjectEconomicAccount;

	@Autowired
	private RepositoryRebalancesCount repoRebalanceCount;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoProjectEconomicAccount;
	}
	
	@Override
	public SuperEntity update(SuperEntity superEntity) {
		ProjectEconomicAccount projectEconomicAccount = (ProjectEconomicAccount) superEntity;
		projectEconomicAccount.setSumExpenses123Budget(projectEconomicAccount.getExpenseBaseYearPlus1Budget1() + projectEconomicAccount.getExpenseBaseYearPlus1Budget2() + projectEconomicAccount.getExpenseBaseYearPlus1Budget3() + projectEconomicAccount.getExpenseBaseYearPlus1Budget4() + projectEconomicAccount.getExpenseBaseYearPlus2Budget() + projectEconomicAccount.getExpenseBaseYearPlus3Budget());
		projectEconomicAccount.setSumExpenses123Others(projectEconomicAccount.getExpenseBaseYearPlus1Others1() + projectEconomicAccount.getExpenseBaseYearPlus1Others2() + projectEconomicAccount.getExpenseBaseYearPlus1Others3() + projectEconomicAccount.getExpenseBaseYearPlus1Others4() + projectEconomicAccount.getExpenseBaseYearPlus2Others() + projectEconomicAccount.getExpenseBaseYearPlus3Others());
		projectEconomicAccount.setSumExpensesBaseYearPlus1Budget(projectEconomicAccount.getExpenseBaseYearPlus1Budget1() + projectEconomicAccount.getExpenseBaseYearPlus1Budget2() + projectEconomicAccount.getExpenseBaseYearPlus1Budget3() + projectEconomicAccount.getExpenseBaseYearPlus1Budget4());
		projectEconomicAccount.setSumExpensesBaseYearPlus1Others(projectEconomicAccount.getExpenseBaseYearPlus1Others1() + projectEconomicAccount.getExpenseBaseYearPlus1Others2() + projectEconomicAccount.getExpenseBaseYearPlus1Others3() + projectEconomicAccount.getExpenseBaseYearPlus1Others4());
		try {
			RebalancesCount rc = repoRebalanceCount.findOne(new Long(1));
			int numReb = rc.getRebalancesCount();
			if (numReb > 0) {
				List<RebalanceTwoFields> l = projectEconomicAccount.getRebalances();
				for (int i = 0; i < l.size(); i++) {
					l.get(i).setSumValueB(l.get(i).sumValueBudget());
					l.get(i).setSumValueO(l.get(i).sumValueOthers());
					projectEconomicAccount.setSumExpenses123Budget(projectEconomicAccount.getSumExpenses123Budget() + l.get(i).getSumValueB());
					projectEconomicAccount.setSumExpenses123Others(projectEconomicAccount.getSumExpenses123Others() + l.get(i).getSumValueO());
				}
				projectEconomicAccount.setRebalances(l);
			}
		} catch (NullPointerException ex) {}
		return super.update(projectEconomicAccount);
	}
	
}

package com.attozoic.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ActivityGoalIndicator;
import com.attozoic.main.model.ProgrammeGoalIndicator;
import com.attozoic.main.model.ProjectEconomicAccount;
import com.attozoic.main.model.ProjectGoalIndicator;
import com.attozoic.main.model.RebalancesCount;
import com.attozoic.main.model.balance.BalanceText;
import com.attozoic.main.repositories.RepositoryActivityEconomicAccount;
import com.attozoic.main.repositories.RepositoryActivityGoalIndicator;
import com.attozoic.main.repositories.RepositoryProgrammeGoalIndicator;
import com.attozoic.main.repositories.RepositoryProjectEconomicAccount;
import com.attozoic.main.repositories.RepositoryProjectGoalIndicator;
import com.attozoic.main.repositories.RepositoryRebalancesCount;

@Repository
public class DaoEntityWithRebalances {

	// UPDATE/SAVE AFTER ADD/REMOVE ???
	
	@Autowired
	private RepositoryProgrammeGoalIndicator repoProgrammeGoalIndicator;
	
	@Autowired
	private RepositoryActivityGoalIndicator repoActivityGoalIndicator;

	@Autowired
	private RepositoryActivityEconomicAccount repoActivityEconomicAccount;
	
	@Autowired
	private RepositoryProjectGoalIndicator repoProjectGoalIndicator;

	@Autowired
	private RepositoryProjectEconomicAccount repoProjectEconomicAccount;
	
	@Autowired
	private RepositoryRebalancesCount repoRebCount;
	
	public void addRebalance() {
		addProgrammeGoalIndicatorRebalance();
		addActivityGoalIndicatorRebalance();
		addActivityEconomicAccountRebalance();
		addProjectGoalIndicatorRebalance();
		addProjectEconomicAccountRebalance();
	}
	
	public void removeRebalance() {
		try{
			RebalancesCount rc = repoRebCount.findOne(new Long(1));
			int numRebalances = rc.getRebalancesCount();
			if (numRebalances > 0) {
				removeProgrammeGoalIndicatorRebalance();
				removeActivityGoalIndicatorRebalance();
				removeActivityEcconomicAccountRebalance();
				removeProjectGoalIndicatorRebalance();
				removeProjectEcconomicAccountRebalance();
			} else {
				System.err.println("0 rebalances");
			}
		} catch (Exception ex) {
			System.err.println("Zero rebalances");
		}
	}
	
	private void addProgrammeGoalIndicatorRebalance() {
		List<ProgrammeGoalIndicator> indicators = repoProgrammeGoalIndicator.findAll();
		for (ProgrammeGoalIndicator programmeGoalIndicator : indicators) {
			try {
				List<BalanceText> indicatorValues = programmeGoalIndicator.getBalancesText();
				indicatorValues.add((indicatorValues.size()-3), new BalanceText());
				programmeGoalIndicator.setBalancesText(indicatorValues);
				repoProgrammeGoalIndicator.save(programmeGoalIndicator);
			} catch (Exception ex) {}
		}
	}
	
	private void removeProgrammeGoalIndicatorRebalance() {
		List<ProgrammeGoalIndicator> indicators = repoProgrammeGoalIndicator.findAll();
		for (ProgrammeGoalIndicator programmeGoalIndicator : indicators) {
			List<BalanceText> indicatorValues = programmeGoalIndicator.getBalancesText();
			indicatorValues.remove((indicatorValues.size()-4));
			programmeGoalIndicator.setBalancesText(indicatorValues);
			repoProgrammeGoalIndicator.save(programmeGoalIndicator);
		}
	}
	
	private void addActivityGoalIndicatorRebalance() {
		List<ActivityGoalIndicator> indicators = repoActivityGoalIndicator.findAll();
		for (ActivityGoalIndicator activityGoalIndicator : indicators) {
			try {
				List<BalanceText> indicatorValues = activityGoalIndicator.getBalancesText();
				indicatorValues.add((indicatorValues.size()-3), new BalanceText());
				activityGoalIndicator.setBalancesText(indicatorValues);
				repoActivityGoalIndicator.save(activityGoalIndicator);
			} catch (Exception ex) {}
		}
	}
	
	private void removeActivityGoalIndicatorRebalance() {
		List<ActivityGoalIndicator> indicators = repoActivityGoalIndicator.findAll();
		for (ActivityGoalIndicator activityGoalIndicator : indicators) {
			List<BalanceText> indicatorValues = activityGoalIndicator.getBalancesText();
			indicatorValues.remove((indicatorValues.size()-4));
			activityGoalIndicator.setBalancesText(indicatorValues);
			repoActivityGoalIndicator.save(activityGoalIndicator);
		}
	}
	
	// OK
	private void addActivityEconomicAccountRebalance() {
		List<ActivityEconomicAccount> activityEconomicAccounts = repoActivityEconomicAccount.findAll();
		for (ActivityEconomicAccount activityEconomicAccount : activityEconomicAccounts) {
			activityEconomicAccount.addRebalance();
			repoActivityEconomicAccount.save(activityEconomicAccount);
		}
	}
	
	private void removeActivityEcconomicAccountRebalance() {
		List<ActivityEconomicAccount> economicAccounts = repoActivityEconomicAccount.findAll();
		for (ActivityEconomicAccount activityEconomicAccount : economicAccounts) {
			activityEconomicAccount.removeRebalance();
			repoActivityEconomicAccount.save(activityEconomicAccount);
		}
	}
	
	private void addProjectGoalIndicatorRebalance() {
		List<ProjectGoalIndicator> indicators = repoProjectGoalIndicator.findAll();
		for (ProjectGoalIndicator projectGoalIndicator : indicators) {
			try {
				List<BalanceText> indicatorValues = projectGoalIndicator.getBalancesText();
				indicatorValues.add((indicatorValues.size()-3), new BalanceText());
				projectGoalIndicator.setBalancesText(indicatorValues);
				repoProjectGoalIndicator.save(projectGoalIndicator);
			} catch (Exception ex) {}
		}
	}
	
	private void removeProjectGoalIndicatorRebalance() {
		List<ProjectGoalIndicator> indicators = repoProjectGoalIndicator.findAll();
		for (ProjectGoalIndicator projectGoalIndicator : indicators) {
			List<BalanceText> indicatorValues = projectGoalIndicator.getBalancesText();
			indicatorValues.remove((indicatorValues.size()-4));
			projectGoalIndicator.setBalancesText(indicatorValues);
			repoProjectGoalIndicator.save(projectGoalIndicator);
		}
	}
	
	// OK
	private void addProjectEconomicAccountRebalance() {
		List<ProjectEconomicAccount> economicAccounts = repoProjectEconomicAccount.findAll();
		for (ProjectEconomicAccount projectEconomicAccount : economicAccounts) {
			projectEconomicAccount.addRebalance();
			repoProjectEconomicAccount.save(projectEconomicAccount);
		}
	}
	
	private void removeProjectEcconomicAccountRebalance() {
		List<ProjectEconomicAccount> economicAccounts = repoProjectEconomicAccount.findAll();
		for (ProjectEconomicAccount projectEconomicAccount : economicAccounts) {
			projectEconomicAccount.removeRebalance();
			repoProjectEconomicAccount.save(projectEconomicAccount);
		}
	}
	
//	private void addActivityFinancialSourceReb() {
//		List<ActivityFinancialSource> l = repoActivityFinancialSource.findAll();
//		for (ActivityFinancialSource activityFinancialSource : l) {
//			try {
//				List<RebalanceOneField> list = activityFinancialSource.getRebalances();
//				list.add(new RebalanceOneField());
//				activityFinancialSource.setRebalances(list);
//				repoActivityFinancialSource.save(activityFinancialSource);
//			} catch (Exception ex) {
//				System.out.println();
//			}
//		}
//	}
//	
//	private void removeActivityFinancialSourceReb() {
//		List<ActivityFinancialSource> l = repoActivityFinancialSource.findAll();
//		for (ActivityFinancialSource activityFinancialSource : l) {
//			activityFinancialSource.getRebalances().remove(activityFinancialSource.getRebalances().size()-1);
//		}
//	}
	
}

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
import com.attozoic.main.repositories.RepositoryActivityEconomicAccount;
import com.attozoic.main.repositories.RepositoryActivityGoalIndicator;
import com.attozoic.main.repositories.RepositoryProgrammeGoalIndicator;
import com.attozoic.main.repositories.RepositoryProjectEconomicAccount;
import com.attozoic.main.repositories.RepositoryProjectGoalIndicator;
import com.attozoic.main.repositories.RepositoryRebalancesCount;

@Repository
public class DaoEntityWithRebalances {
	
	@Autowired
	private RepositoryProgrammeGoalIndicator repoProgrammeGoalIndicator;
	
	@Autowired
	private RepositoryActivityGoalIndicator repoActivityGoalIndicator;

	@Autowired
	private RepositoryActivityEconomicAccount repoActivityEconomicAccount; // OK
	
	@Autowired
	private RepositoryProjectGoalIndicator repoProjectGoalIndicator;

	@Autowired
	private RepositoryProjectEconomicAccount repoProjectEconomicAccount; // OK
	
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
			System.err.println("O rebalances");
		}
	}
	
	private void addProgrammeGoalIndicatorRebalance() {
		List<ProgrammeGoalIndicator> programmeGoalIndicators = repoProgrammeGoalIndicator.findAll();
		for (ProgrammeGoalIndicator programmeGoalIndicator : programmeGoalIndicators) {
			programmeGoalIndicator.addRebalance(repoRebCount.findOne(new Long(1)).getRebalancesCount());
			repoProgrammeGoalIndicator.save(programmeGoalIndicator);
		}
	}
	
	private void removeProgrammeGoalIndicatorRebalance() {
		List<ProgrammeGoalIndicator> programmeGoalIndicators = repoProgrammeGoalIndicator.findAll();
		for (ProgrammeGoalIndicator programmeGoalIndicator : programmeGoalIndicators) {
			programmeGoalIndicator.removeRebalance(repoRebCount.findOne(new Long(1)).getRebalancesCount());
			repoProgrammeGoalIndicator.save(programmeGoalIndicator);
		}
	}
	
	private void addActivityGoalIndicatorRebalance() {
		List<ActivityGoalIndicator> activityGoalIndicators = repoActivityGoalIndicator.findAll();
		for (ActivityGoalIndicator activityGoalIndicator : activityGoalIndicators) {
			activityGoalIndicator.addRebalance(repoRebCount.findOne(new Long(1)).getRebalancesCount());
			repoActivityGoalIndicator.save(activityGoalIndicator);
		}
	}
	
	private void removeActivityGoalIndicatorRebalance() {
		List<ActivityGoalIndicator> activityGoalIndicators = repoActivityGoalIndicator.findAll();
		for (ActivityGoalIndicator activityGoalIndicator : activityGoalIndicators) {
			activityGoalIndicator.removeRebalance(repoRebCount.findOne(new Long(1)).getRebalancesCount());
			repoActivityGoalIndicator.save(activityGoalIndicator);
		}
	}
	
	// OK
	private void addActivityEconomicAccountRebalance() {
		List<ActivityEconomicAccount> activityEconomicAccounts = repoActivityEconomicAccount.findAll();
		for (ActivityEconomicAccount activityEconomicAccount : activityEconomicAccounts) {
			activityEconomicAccount.addRebalance(repoRebCount.findOne(new Long(1)).getRebalancesCount());
			repoActivityEconomicAccount.save(activityEconomicAccount);
		}
	}
	
	private void removeActivityEcconomicAccountRebalance() {
		List<ActivityEconomicAccount> activityEconomicAccounts = repoActivityEconomicAccount.findAll();
		for (ActivityEconomicAccount activityEconomicAccount : activityEconomicAccounts) {
			activityEconomicAccount.removeRebalance(repoRebCount.findOne(new Long(1)).getRebalancesCount());
			repoActivityEconomicAccount.save(activityEconomicAccount);
		}
	}
	
	private void addProjectGoalIndicatorRebalance() {
		List<ProjectGoalIndicator> projectGoalIndicators = repoProjectGoalIndicator.findAll();
		for (ProjectGoalIndicator projectGoalIndicator : projectGoalIndicators) {
			projectGoalIndicator.addRebalance(repoRebCount.findOne(new Long(1)).getRebalancesCount());
			repoProjectGoalIndicator.save(projectGoalIndicator);
		}
	}
	
	private void removeProjectGoalIndicatorRebalance() {
		List<ProjectGoalIndicator> projectGoalIndicators = repoProjectGoalIndicator.findAll();
		for (ProjectGoalIndicator projectGoalIndicator : projectGoalIndicators) {
			projectGoalIndicator.removeRebalance(repoRebCount.findOne(new Long(1)).getRebalancesCount());
			repoProjectGoalIndicator.save(projectGoalIndicator);
		}
	}
	
	// OK
	private void addProjectEconomicAccountRebalance() {
		List<ProjectEconomicAccount> projectEconomicAccounts = repoProjectEconomicAccount.findAll();
		for (ProjectEconomicAccount projectEconomicAccount : projectEconomicAccounts) {
			projectEconomicAccount.addRebalance(repoRebCount.findOne(new Long(1)).getRebalancesCount());
			repoProjectEconomicAccount.save(projectEconomicAccount);
		}
	}
	
	private void removeProjectEcconomicAccountRebalance() {
		List<ProjectEconomicAccount> projectEconomicAccounts = repoProjectEconomicAccount.findAll();
		for (ProjectEconomicAccount projectEconomicAccount : projectEconomicAccounts) {
			projectEconomicAccount.removeRebalance(repoRebCount.findOne(new Long(1)).getRebalancesCount());
			repoProjectEconomicAccount.save(projectEconomicAccount);
		}
	}
	
}

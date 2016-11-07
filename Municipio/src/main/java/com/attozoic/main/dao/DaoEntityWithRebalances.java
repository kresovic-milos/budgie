package com.attozoic.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.ActivityGoalIndicator;
import com.attozoic.main.model.ProgrammeGoalIndicator;
import com.attozoic.main.model.ProjectEconomicAccount;
import com.attozoic.main.model.ProjectFinancialSource;
import com.attozoic.main.model.ProjectGoalIndicator;
import com.attozoic.main.model.RebalanceOneField;
import com.attozoic.main.model.RebalanceTwoFields;
import com.attozoic.main.repositories.RepositoryActivityFinancialSource;
import com.attozoic.main.repositories.RepositoryActivityGoalIndicator;
import com.attozoic.main.repositories.RepositoryActivityEconomicAccount;
import com.attozoic.main.repositories.RepositoryProgrameGoalIndicator;
import com.attozoic.main.repositories.RepositoryProjectEconomicAccount;
import com.attozoic.main.repositories.RepositoryProjectFinancialSource;
import com.attozoic.main.repositories.RepositoryProjectGoalIndicator;

@Repository
public class DaoEntityWithRebalances {

	@Autowired
	private RepositoryProgrameGoalIndicator repoProgrammeGoalIndicator;
	
	@Autowired
	private RepositoryActivityGoalIndicator repoActivityGoalIndicator;
	
	@Autowired
	private RepositoryActivityFinancialSource repoActivityFinancialSource;

	@Autowired
	private RepositoryActivityEconomicAccount repoActivityEconomicAccount;
	
	@Autowired
	private RepositoryProjectGoalIndicator repoProjectGoalIndicator;
	
	@Autowired
	private RepositoryProjectFinancialSource repoProjectFinancialSource;

	@Autowired
	private RepositoryProjectEconomicAccount repoProjectEconomicAccount;
	
	public void addRebalance() {
		addProgrammeGoalIndicatorReb();
		addActivityGoalIndicatorReb();
		addActivityFinancialSourceReb();
		addActivityEconomicAccountReb();
		addProjectGoalIndicatorReb();
		addProjectFinancialSourceReb();
		addProjectEconomicAccountReb();
	}
	
	public void removeRebalance() {
		try{
			removeProgrammeGoalIndicatorReb();
			removeActivityGoalIndicatorReb();
			removeActivityFinancialSourceReb();
			removeActivityEcconomicAccountReb();
			removeProjectGoalIndicatorReb();
			removeProjectFinancialSourceReb();
			removeProjectEcconomicAccountReb();
		} catch (Exception ex) {
			System.err.println("Zero rebalances");
		}
	}
	
	private void addProgrammeGoalIndicatorReb() {
		List<ProgrammeGoalIndicator> l = repoProgrammeGoalIndicator.findAll();
		for (ProgrammeGoalIndicator programmeGoalIndicator : l) {
			try {
				List<RebalanceOneField> list = programmeGoalIndicator.getRebalances();
				list.add(new RebalanceOneField());
				programmeGoalIndicator.setRebalances(list);
				repoProgrammeGoalIndicator.save(programmeGoalIndicator);
			} catch (Exception ex) {
				System.out.println("Ufacen Indikator");
			}
		}
	}
	
	private void removeProgrammeGoalIndicatorReb() {
		List<ProgrammeGoalIndicator> l = repoProgrammeGoalIndicator.findAll();
		for (ProgrammeGoalIndicator programmeGoalIndicator : l) {
			programmeGoalIndicator.getRebalances().remove(programmeGoalIndicator.getRebalances().size()-1);
		}
	}
	
	private void addActivityGoalIndicatorReb() {
		List<ActivityGoalIndicator> l = repoActivityGoalIndicator.findAll();
		for (ActivityGoalIndicator activityGoalIndicator : l) {
			try {
				List<RebalanceOneField> list = activityGoalIndicator.getRebalances();
				list.add(new RebalanceOneField());
				activityGoalIndicator.setRebalances(list);
				repoActivityGoalIndicator.save(activityGoalIndicator);
			} catch (Exception ex) {
				System.out.println();
			}
		}
	}
	
	private void removeActivityGoalIndicatorReb() {
		List<ActivityGoalIndicator> l = repoActivityGoalIndicator.findAll();
		for (ActivityGoalIndicator activityGoalIndicator : l) {
			activityGoalIndicator.getRebalances().remove(activityGoalIndicator.getRebalances().size()-1);
		}
	}
	
	private void addActivityFinancialSourceReb() {
		List<ActivityFinancialSource> l = repoActivityFinancialSource.findAll();
		for (ActivityFinancialSource activityFinancialSource : l) {
			try {
				List<RebalanceOneField> list = activityFinancialSource.getRebalances();
				list.add(new RebalanceOneField());
				activityFinancialSource.setRebalances(list);
				repoActivityFinancialSource.save(activityFinancialSource);
			} catch (Exception ex) {
				System.out.println();
			}
		}
	}
	
	private void removeActivityFinancialSourceReb() {
		List<ActivityFinancialSource> l = repoActivityFinancialSource.findAll();
		for (ActivityFinancialSource activityFinancialSource : l) {
			activityFinancialSource.getRebalances().remove(activityFinancialSource.getRebalances().size()-1);
		}
	}
	
	private void addActivityEconomicAccountReb() {
		List<ActivityEconomicAccount> l = repoActivityEconomicAccount.findAll();
		for (ActivityEconomicAccount activityEconomicAccount : l) {
			try {
				List<RebalanceTwoFields> list = activityEconomicAccount.getRebalances();
				list.add(new RebalanceTwoFields());
				activityEconomicAccount.setRebalances(list);
				repoActivityEconomicAccount.save(activityEconomicAccount);
			} catch (Exception ex) {
				System.out.println();
			}
		}
	}
	
	private void removeActivityEcconomicAccountReb() {
		List<ActivityEconomicAccount> l = repoActivityEconomicAccount.findAll();
		for (ActivityEconomicAccount activityEconomicAccount : l) {
			activityEconomicAccount.getRebalances().remove(activityEconomicAccount.getRebalances().size()-1);
		}
	}
	
	private void addProjectGoalIndicatorReb() {
		List<ProjectGoalIndicator> l = repoProjectGoalIndicator.findAll();
		for (ProjectGoalIndicator projectGoalIndicator : l) {
			try {
				List<RebalanceOneField> list = projectGoalIndicator.getRebalances();
				list.add(new RebalanceOneField());
				projectGoalIndicator.setRebalances(list);
				repoProjectGoalIndicator.save(projectGoalIndicator);
			} catch (Exception ex) {
				System.out.println();
			}
		}
	}
	
	private void removeProjectGoalIndicatorReb() {
		List<ProjectGoalIndicator> l = repoProjectGoalIndicator.findAll();
		for (ProjectGoalIndicator projectGoalIndicator : l) {
			projectGoalIndicator.getRebalances().remove(projectGoalIndicator.getRebalances().size()-1);
		}
	}
	
	private void addProjectFinancialSourceReb() {
		List<ProjectFinancialSource> l = repoProjectFinancialSource.findAll();
		for (ProjectFinancialSource projectFinancialSource : l) {
			try {
				List<RebalanceOneField> list = projectFinancialSource.getRebalances();
				list.add(new RebalanceOneField());
				projectFinancialSource.setRebalances(list);
				repoProjectFinancialSource.save(projectFinancialSource);
			} catch (Exception ex) {
				System.out.println();
			}
		}
	}
	
	private void removeProjectFinancialSourceReb() {
		List<ProjectFinancialSource> l = repoProjectFinancialSource.findAll();
		for (ProjectFinancialSource projectFinancialSource : l) {
			projectFinancialSource.getRebalances().remove(projectFinancialSource.getRebalances().size()-1);
		}
	}
	
	private void addProjectEconomicAccountReb() {
		List<ProjectEconomicAccount> l = repoProjectEconomicAccount.findAll();
		for (ProjectEconomicAccount projectEconomicAccount : l) {
			try {
				List<RebalanceTwoFields> list = projectEconomicAccount.getRebalances();
				list.add(new RebalanceTwoFields());
				projectEconomicAccount.setRebalances(list);
				repoProjectEconomicAccount.save(projectEconomicAccount);
			} catch (Exception ex) {
				System.out.println();
			}
		}
	}
	
	private void removeProjectEcconomicAccountReb() {
		List<ProjectEconomicAccount> l = repoProjectEconomicAccount.findAll();
		for (ProjectEconomicAccount projectEconomicAccount : l) {
			projectEconomicAccount.getRebalances().remove(projectEconomicAccount.getRebalances().size()-1);
		}
	}
	
}

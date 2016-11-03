package com.attozoic.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.ActivityGoalIndicator;
import com.attozoic.main.model.EconomicAccount;
import com.attozoic.main.model.ProgrammeFinancialSource;
import com.attozoic.main.model.ProgrammeGoalIndicator;
import com.attozoic.main.model.ProjectFinancialSource;
import com.attozoic.main.model.ProjectGoalIndicator;
import com.attozoic.main.model.RebalanceOneField;
import com.attozoic.main.model.RebalanceTwoFields;
import com.attozoic.main.repositories.RepositoryActivityFinancialSource;
import com.attozoic.main.repositories.RepositoryActivityGoalIndicator;
import com.attozoic.main.repositories.RepositoryEconomicAccount;
import com.attozoic.main.repositories.RepositoryProgrameGoalIndicator;
import com.attozoic.main.repositories.RepositoryProgrammeFinancialSource;
import com.attozoic.main.repositories.RepositoryProjectFinancialSource;
import com.attozoic.main.repositories.RepositoryProjectGoalIndicator;

@Repository
public class DaoEntityWithRebalances {

	@Autowired
	private RepositoryProgrameGoalIndicator repoProgrammeGoalIndicator;
	
	@Autowired
	private RepositoryProgrammeFinancialSource repoProgrammeFinancialSource;
	
	@Autowired
	private RepositoryActivityGoalIndicator repoActivityGoalIndicator;
	
	@Autowired
	private RepositoryActivityFinancialSource repoActivityFinancialSource;
	
	@Autowired
	private RepositoryProjectGoalIndicator repoProjectGoalIndicator;
	
	@Autowired
	private RepositoryProjectFinancialSource repoProjectFinancialSource;

	@Autowired
	private RepositoryEconomicAccount repoEconomicAccount;

	public int getRebalanceCount() {
		return (repoProgrammeGoalIndicator.findOne(new Long(1))).getRebalances().size();
	}
	
	public void addRebalance() {
		addProgrammeGoalIndicatorReb();
		addProgrammeFinancialSourceReb();
		addActivityGoalIndicatorReb();
		addActivityFinancialSourceReb();
		addProjectGoalIndicatorReb();
		addProjectFinancialSourceReb();
		addEconomicAccountReb();
	}
	
	public void removeRebalance() {
		try{
			removeProgrammeGoalIndicatorReb();
			removeProgrammeFinancialSourceReb();
			removeActivityGoalIndicatorReb();
			removeActivityFinancialSourceReb();
			removeProjectGoalIndicatorReb();
			removeProjectFinancialSourceReb();
			removeEcconomicAccountReb();
		} catch (Exception ex) {
			System.err.println("Zero rebalances");
		}
	}
	
	private void addProgrammeGoalIndicatorReb() {
		List<ProgrammeGoalIndicator> l = repoProgrammeGoalIndicator.findAll();
		for (ProgrammeGoalIndicator programmeGoalIndicator : l) {
			programmeGoalIndicator.getRebalances().add(new RebalanceOneField());
			repoProgrammeGoalIndicator.save(programmeGoalIndicator);
		}
	}
	
	private void removeProgrammeGoalIndicatorReb() {
		List<ProgrammeGoalIndicator> l = repoProgrammeGoalIndicator.findAll();
		for (ProgrammeGoalIndicator programmeGoalIndicator : l) {
			programmeGoalIndicator.getRebalances().remove(programmeGoalIndicator.getRebalances().size()-1);
		}
	}
	
	private void addProgrammeFinancialSourceReb() {
		List<ProgrammeFinancialSource> l = repoProgrammeFinancialSource.findAll();
		for (ProgrammeFinancialSource programmeFinancialSource : l) {
			programmeFinancialSource.getRebalances().add(new RebalanceOneField());
			repoProgrammeFinancialSource.save(programmeFinancialSource);
		}
	}
	
	private void removeProgrammeFinancialSourceReb() {
		List<ProgrammeFinancialSource> l = repoProgrammeFinancialSource.findAll();
		for (ProgrammeFinancialSource programmeFinancialSource : l) {
			programmeFinancialSource.getRebalances().remove(programmeFinancialSource.getRebalances().size()-1);
		}
	}
	
	private void addActivityGoalIndicatorReb() {
		List<ActivityGoalIndicator> l = repoActivityGoalIndicator.findAll();
		for (ActivityGoalIndicator activityGoalIndicator : l) {
			activityGoalIndicator.getRebalances().add(new RebalanceOneField());
			repoActivityGoalIndicator.save(activityGoalIndicator);
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
			activityFinancialSource.getRebalances().add(new RebalanceOneField());
			repoActivityFinancialSource.save(activityFinancialSource);
		}
	}
	
	private void removeActivityFinancialSourceReb() {
		List<ActivityFinancialSource> l = repoActivityFinancialSource.findAll();
		for (ActivityFinancialSource activityFinancialSource : l) {
			activityFinancialSource.getRebalances().remove(activityFinancialSource.getRebalances().size()-1);
		}
	}
	
	private void addProjectGoalIndicatorReb() {
		List<ProjectGoalIndicator> l = repoProjectGoalIndicator.findAll();
		for (ProjectGoalIndicator projectGoalIndicator : l) {
			projectGoalIndicator.getRebalances().add(new RebalanceOneField());
			repoProjectGoalIndicator.save(projectGoalIndicator);
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
			projectFinancialSource.getRebalances().add(new RebalanceOneField());
			repoProjectFinancialSource.save(projectFinancialSource);
		}
	}
	
	private void removeProjectFinancialSourceReb() {
		List<ProjectFinancialSource> l = repoProjectFinancialSource.findAll();
		for (ProjectFinancialSource projectFinancialSource : l) {
			projectFinancialSource.getRebalances().remove(projectFinancialSource.getRebalances().size()-1);
		}
	}
	
	private void addEconomicAccountReb() {
		List<EconomicAccount> l = repoEconomicAccount.findAll();
		for (EconomicAccount economicAccount : l) {
			economicAccount.getRebalances().add(new RebalanceTwoFields());
			repoEconomicAccount.save(economicAccount);
		}
	}
	
	private void removeEcconomicAccountReb() {
		List<EconomicAccount> l = repoEconomicAccount.findAll();
		for (EconomicAccount economicAccount : l) {
			economicAccount.getRebalances().remove(economicAccount.getRebalances().size()-1);
		}
	}
	
}

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
	private RepositoryActivityFinancialSource repositoryActivityFinancialSource;
	
	@Autowired
	private RepositoryProjectGoalIndicator repositoryProjectGoalIndicator;
	
	@Autowired
	private RepositoryProjectFinancialSource repoProjectFinancialSource;

	@Autowired
	private RepositoryEconomicAccount repoEconomicAccount;

	public void addRebalance() {
		addProgrammeGoalIndicatorReb();
		addProgrammeFinancialSourceReb();
		addActivityGoalIndicatorReb();
		addActivityFinancialSourceReb();
		addProjectGoalIndicatorReb();
		addProjectFinancialSourceReb();
		addEconomicAccountReb();
	}
	
	private void addProgrammeGoalIndicatorReb() {
		List<ProgrammeGoalIndicator> l = repoProgrammeGoalIndicator.findAll();
		for (ProgrammeGoalIndicator programmeGoalIndicator : l) {
			programmeGoalIndicator.getRebalances().add(new RebalanceOneField());
		}
	}
	
	private void addProgrammeFinancialSourceReb() {
		List<ProgrammeFinancialSource> l = repoProgrammeFinancialSource.findAll();
		for (ProgrammeFinancialSource programmeFinancialSource : l) {
			List<RebalanceOneField> list = programmeFinancialSource.getRebalances(); 
			list.add(new RebalanceOneField());
			programmeFinancialSource.setRebalances(list);
			repoProgrammeFinancialSource.save(programmeFinancialSource);
		}
	}
	
	private void addActivityGoalIndicatorReb() {
		List<ActivityGoalIndicator> l = repoActivityGoalIndicator.findAll();
		for (ActivityGoalIndicator activityGoalIndicator : l) {
			activityGoalIndicator.getRebalances().add(new RebalanceOneField());
		}
	}
	
	private void addActivityFinancialSourceReb() {
		List<ActivityFinancialSource> l = repositoryActivityFinancialSource.findAll();
		for (ActivityFinancialSource activityFinancialSource : l) {
			activityFinancialSource.getRebalances().add(new RebalanceOneField());
		}
	}
	
	private void addProjectGoalIndicatorReb() {
		List<ProjectGoalIndicator> l = repositoryProjectGoalIndicator.findAll();
		for (ProjectGoalIndicator projectGoalIndicator : l) {
			projectGoalIndicator.getRebalances().add(new RebalanceOneField());
		}
	}
	
	private void addProjectFinancialSourceReb() {
		List<ProjectFinancialSource> l = repoProjectFinancialSource.findAll();
		for (ProjectFinancialSource projectFinancialSource : l) {
			projectFinancialSource.getRebalances().add(new RebalanceOneField());
		}
	}
	
	private void addEconomicAccountReb() {
		List<EconomicAccount> l = repoEconomicAccount.findAll();
		for (EconomicAccount economicAccount : l) {
			economicAccount.getRebalances().add(new RebalanceTwoFields());
		}
	}
}

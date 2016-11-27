package com.attozoic.main.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Project;
import com.attozoic.main.model.ProjectEconomicAccount;
import com.attozoic.main.model.ProjectGoal;
import com.attozoic.main.model.SuperEconomicAccount;
import com.attozoic.main.model.dto.DtoFinanceFooter;
import com.attozoic.main.model.dto.DtoProjectEconomicAccount;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProject;
import com.attozoic.main.repositories.RepositoryRebalancesCount;

@Repository
public class DaoProject extends DaoEntity {

	@Autowired
	private RepositoryProject repoProject;
	
	@Autowired
	private RepositoryRebalancesCount repoRebalanceCount;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoProject;
	}
	
	// getProjectFinancialSourceFooter()
	public DtoFinanceFooter getProjectFinancialSourceFooter(Long uid) {
		return repoProject.findOne(uid).generateProjectFinancialSourceFooter();
	}
	
	// getProjectFinancialSourceMap
	public Map<String, double[]> getProjectFinancialSourceMap(Long uid) {
		return repoProject.findOne(uid).generateProjectFinancialSourceMap();
	}
	
	// getProjectEconomicAccountFooter
	public SuperEconomicAccount getProjectEconomicAccountFooter(Long uid) {
		Project project = (Project)getRepoEntity().findOne(uid);
		int numRebalances = 0;
		try {
			numRebalances = repoRebalanceCount.findOne(new Long(1)).getRebalancesCount();
		} catch (NullPointerException ex) {}
		return project.generateProjectEconomicAccountFooter(numRebalances);
	}
	
	// getProjectEconomicAccountDTOsList
	public List<DtoProjectEconomicAccount> getProjectEconomicAccountsList(Long uid) {
		Project project = (Project)getRepoEntity().findOne(uid);
		int numRebalances = 0;
		try {
			numRebalances = repoRebalanceCount.findOne(new Long(1)).getRebalancesCount();
		} catch (NullPointerException ex) {}
		return project.generateProjectEconomicAccountsList(numRebalances);
	}
	
	// addProjectGoal
	@SuppressWarnings("unchecked")
	public ProjectGoal addGoal(Long uid, ProjectGoal goal) {
		Project project = (Project) getRepoEntity().findOne(uid);
		goal.setProject(project);
		//getRepoEntity().save(project);
		return (ProjectGoal) getRepoEntity().save(goal);
	}
	
	// addProjectEconomicAccount
	@SuppressWarnings("unchecked")
	public ProjectEconomicAccount addProjectEconomicAccount(Long uid, ProjectEconomicAccount projectEconomicAccount) {
		Project project = (Project) getRepoEntity().findOne(uid);
		projectEconomicAccount.setProject(project);
		int numRebalances = 0;
		try {
			numRebalances = repoRebalanceCount.findOne(new Long(1)).getRebalancesCount();
		} catch (NullPointerException ex) {}
			projectEconomicAccount.generateBalances(numRebalances);
		return (ProjectEconomicAccount) getRepoEntity().save(projectEconomicAccount);
	}
	
}

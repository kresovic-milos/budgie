package com.attozoic.main.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActiveState;
import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.Programme;
import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.model.Project;
import com.attozoic.main.model.balance.Balance;
import com.attozoic.main.model.dto.DtoFinanceFooter;
import com.attozoic.main.model.dto.DtoProgrammeEconomicAccount;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProgramme;
import com.attozoic.main.repositories.RepositoryRebalancesCount;
import com.attozoic.main.repositories.repositoriesBalance.RepositoryBalance;

@Repository
public class DaoProgramme extends DaoEntity {
	
	@Autowired
	private RepositoryProgramme repoProgramme;
	
	@Autowired
	private RepositoryRebalancesCount repoRebalanceCount;
	
	@Autowired
	private RepositoryBalance repoBalance;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoProgramme;
	}
	
	// ALL PROGRAMMES CHART
	public List<Object> getChart(double year) {
		List<Object> activities = repoProgramme.getChart(year);
		List<Object> projects = repoProgramme.getChartP(year);
		List<Object> list = new ArrayList<>();
		for(int i = 0; i < activities.size(); i++) {
			Object[] a = new Object[2]; 
			a = (Object[])activities.get(i);
			Object[] niz = new Object[2]; 
			double sum = (double)a[1];
			for(int j = 0; j < projects.size(); j++) {
				Object[] p = new Object[2]; 
				p = (Object[])projects.get(j);
				if (a[0].equals(p[0])) {
					sum += (double)p[1];
				}
			}
			niz[0] = (String)a[0];
			niz[1] = sum;
			list.add(niz);
		}
		return list;
	}
	
	public List<ProgrammeGoal> getProgrammeGoals(Long uid) {
		return repoProgramme.getProgrammeGoals(uid);
	}
	
	//GENERATE BALANCES AMOUNTS
	public void generateBalancesAmounts(Long uid) {
		Programme programme = (Programme)repoProgramme.findOne(uid);
		List<Activity> activities = programme.getActivities();
		for (Activity activity : activities) {
			if (activity.getActiveState() == ActiveState.ACTIVE) {
				List<ActivityEconomicAccount> activityEconomicAccounts = activity.getActivityEconomicAccounts();
				for (ActivityEconomicAccount activityEconomicAccount : activityEconomicAccounts) {
					if (activityEconomicAccount.getActiveState() == ActiveState.ACTIVE) {
						List<Balance> balances = activityEconomicAccount.getBalances();
						for (Balance balance : balances) {
							balance.generateBalanceAmount();
							repoBalance.save(balance);
						}
					}
				}
			}
		}
	}
	
	// getProgrammeFinancialSourceFooter
	public DtoFinanceFooter getProgrammeFinancialSourceFooter(Long uid) {
		return repoProgramme.findOne(uid).generateProgrammeFinancialSourceFooter();
	}
	
	// getProgrammeFinancialSourceMap
	public Map<String, double[]> getProgrammeFinancialSourceMap(Long uid) {
		return repoProgramme.findOne(uid).generateProgrammeFinancialSourceMap();
	}
	
	// getProgrammeEconomicAccountFooter
	public DtoProgrammeEconomicAccount getProgrammeEconomicAccountFooter(Long uid) {
		Programme programme = (Programme) getRepoEntity().findOne(uid);
		int numRebalances = 0;
		try {
			numRebalances = repoRebalanceCount.findOne(new Long(1)).getRebalancesCount();
		} catch (NullPointerException ex) {}
		return programme.generateProgrammeEconomicAccountFooter(numRebalances);
	}
	
	// getProgrammeEconomicAccountDTOsList
	public List<DtoProgrammeEconomicAccount> getProgrammeEconomicAccountList(Long uid) {
		Programme programme = (Programme) getRepoEntity().findOne(uid);
		int numRebalances = 0;
		try {
			numRebalances = repoRebalanceCount.findOne(new Long(1)).getRebalancesCount();
		} catch (NullPointerException ex) {}
		return programme.generateProgrammeEconomicAccountList(numRebalances);
	}
	
	@SuppressWarnings("unchecked")
	public ProgrammeGoal addProgrammeGoal(Long uid, ProgrammeGoal programmeGoal) {
		Programme programme = (Programme) getRepoEntity().findOne(uid);
		programmeGoal.setProgramme(programme);
		return (ProgrammeGoal) getRepoEntity().save(programmeGoal);
	}
	
	@SuppressWarnings("unchecked")
	public Activity addActivity(Long uid, Activity activity) {
		Programme programme = (Programme) getRepoEntity().findOne(uid);
		activity.setProgramme(programme);
		return (Activity) getRepoEntity().save(activity);
	}
	
	@SuppressWarnings("unchecked")
	public Project addProject(Long uid, Project project) {
		Programme programme = (Programme) getRepoEntity().findOne(uid);
		project.setProgramme(programme);
		return (Project) getRepoEntity().save(project);
	}
	
}

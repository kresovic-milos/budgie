package com.attozoic.main.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.Programme;
import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.model.Project;
import com.attozoic.main.model.dto.DtoFinanceFooter;
import com.attozoic.main.model.dto.DtoProgrammeChart;
import com.attozoic.main.model.dto.DtoProgrammeChartObject;
import com.attozoic.main.model.dto.DtoProgrammeEconomicAccount;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProgramme;
import com.attozoic.main.repositories.RepositoryRebalancesCount;

@Repository
public class DaoProgramme extends DaoEntity {
	
	@Autowired
	private RepositoryProgramme repoProgramme;
	
	@Autowired
	private RepositoryRebalancesCount repoRebalanceCount;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoProgramme;
	}
	
	// getProgrammesChart
	public DtoProgrammeChart getProgrammesChart() {
		double budgetValue = 0;
		List<DtoProgrammeChartObject> programmeChartObjects = new ArrayList<>();
		List<Programme> programmes = repoProgramme.findAll();
		for (Programme programme : programmes) {
			budgetValue += programme.generateProgrammeValue();
		}
		for (Programme programme : programmes) {
			DtoProgrammeChartObject programmeChartObject = programme.generateProgrammeChart();
			programmeChartObject.setPercnetage((programmeChartObject.getValue()/budgetValue)*100);
			programmeChartObjects.add(programmeChartObject);
		}
		DtoProgrammeChart programmesChart = new DtoProgrammeChart(budgetValue, programmeChartObjects);
		return programmesChart;
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

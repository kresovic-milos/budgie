package com.attozoic.main.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.dao.DaoProgramme;
import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.model.Project;
import com.attozoic.main.model.dto.DtoFinanceFooter;
import com.attozoic.main.model.dto.DtoProgrammeChart;
import com.attozoic.main.model.dto.DtoProgrammeEconomicAccount;
import com.attozoic.main.services.ServiceProgramme;

@Service
public class ServiceProgrammeImpl extends ServiceEntityImpl implements ServiceProgramme {

	@Autowired
	private DaoProgramme daoProgramme;
	
	@Override
	public DaoEntity getDaoEntity() {
		return daoProgramme;
	}
	
	@Override
	public DtoProgrammeChart getProgrammesChart() {
		return ((DaoProgramme) getDaoEntity()).getProgrammesChart();
	}
	
	@Override
	public DtoFinanceFooter getProgrammeFinancialSourceFooter(Long uid) {
		return ((DaoProgramme) getDaoEntity()).getProgrammeFinancialSourceFooter(uid);
	}
	
	@Override
	public Map<String, double[]> getProgrammeFinancialSourceMap(Long uid) {
		return ((DaoProgramme) getDaoEntity()).getProgrammeFinancialSourceMap(uid);
	}
	
	@Override
	public DtoProgrammeEconomicAccount getProgrammeEconomicAccountFooter(Long uid) {
		return ((DaoProgramme) getDaoEntity()).getProgrammeEconomicAccountFooter(uid);
	}

	@Override
	public List<DtoProgrammeEconomicAccount> getProgrammeEconomicAccountList(Long uid) {
		return ((DaoProgramme) getDaoEntity()).getProgrammeEconomicAccountList(uid);
	}

	@Override	
	public ProgrammeGoal addProgrammeGoal(Long uid, ProgrammeGoal programmeGoal) {
		return ((DaoProgramme) getDaoEntity()).addProgrammeGoal(uid, programmeGoal);
	}	

	@Override
	public Activity addActivity(Long uid, Activity activity) {
		return ((DaoProgramme) getDaoEntity()).addActivity(uid, activity);
	}
	
	@Override
	public Project addProject(Long uid, Project project) {
		return ((DaoProgramme) getDaoEntity()).addProject(uid, project);
	}

}

package com.attozoic.main.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoDtoActivityProject;
import com.attozoic.main.dao.DaoDtoProgrammeFinancialSource;
import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.dao.DaoProgramme;
import com.attozoic.main.model.Activity;
import com.attozoic.main.model.DtoActivityProject;
import com.attozoic.main.model.DtoProgrammeChart;
import com.attozoic.main.model.DtoProgrammeFinancialSource;
import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.model.Project;
import com.attozoic.main.model.RebalancesCount;
import com.attozoic.main.services.ServiceProgramme;
import com.attozoic.main.services.ServiceRebalancesCount;

@Service
public class ServiceProgrammeImpl extends ServiceEntityImpl implements ServiceProgramme {

	@Autowired
	private DaoProgramme dao;
	
	@Autowired
	private DaoDtoActivityProject daoDto;
	
	@Autowired
	private DaoDtoProgrammeFinancialSource daoDtoFinance;
	
	@Autowired
	private ServiceRebalancesCount serviceReabalanceCount;
	
	@Override
	public DaoEntity getDaoEntity() {
		return dao;
	}
	
	public DaoDtoActivityProject getDaoDto() {
		return daoDto;
	}
	
	public DaoDtoProgrammeFinancialSource getDaoDtoFinance() {
		return daoDtoFinance;
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

	@Override
	public List<DtoActivityProject> getProgrammeDTOs(Long uid) {
		return getDaoDto().getProgrammeDTOs(uid);
	}

	@Override
	public DtoActivityProject getDtoProgramme(Long uid) {
//		int num = 0;
//		try {
//			num = ((RebalancesCount)serviceReabalanceCount.findOne(new Long(1))).getRebalancesCount();
//		} catch (NullPointerException ex) {}
//		return getDaoDto().getDtoProgramme(uid, num);
		return getDaoDto().getActivityProjectFooter(uid);
	}

	@Override
	public DtoProgrammeChart getProgrammeChart() {
		return getDaoDto().getProgrammeChart();
	}

	@Override
	public List<DtoProgrammeFinancialSource> getProgrammeFinanceDto(Long uid) {
		return getDaoDtoFinance().getProgrammeFinanceDto(uid);
	}

	@Override
	public DtoProgrammeFinancialSource getProgrammeFinanceFooterDto(Long uid) {
		int num = 0;
		try {
			num = ((RebalancesCount)serviceReabalanceCount.findOne(new Long(1))).getRebalancesCount();
		} catch (NullPointerException ex) {}
		return getDaoDtoFinance().getProgrammeFinanceFooterDto(uid, num);
	}

}

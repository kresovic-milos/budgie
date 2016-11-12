package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.dao.DaoProgramme;
import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.model.Project;
import com.attozoic.main.services.ServiceProgramme;

@Service
public class ServiceProgrammeImpl extends ServiceEntityImpl implements ServiceProgramme {

	@Autowired
	private DaoProgramme daoProgramme;
	
//	@Autowired
//	private DaoDtoProgrammeItemExpences daoDto;
//	
//	@Autowired
//	private DaoDtoProgrammeFinancialSource daoDtoFinance;
	
	@Override
	public DaoEntity getDaoEntity() {
		return daoProgramme;
	}
	
//	public DaoDtoProgrammeItemExpences getDaoDto() {
//		return daoDto;
//	}
//	
//	public DaoDtoProgrammeFinancialSource getDaoDtoFinance() {
//		return daoDtoFinance;
//	}

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

//	@Override
//	public List<DtoProgrammeExpencesItem> getProgrammeDTOs(Long uid) {
//		return getDaoDto().getProgrammeExpencesItems(uid);
//	}
//
//	@Override
//	public DtoProgrammeExpencesItem getDtoProgramme(Long uid) {
////		int num = 0;
////		try {
////			num = ((RebalancesCount)serviceReabalanceCount.findOne(new Long(1))).getRebalancesCount();
////		} catch (NullPointerException ex) {}
////		return getDaoDto().getDtoProgramme(uid, num);
//		return getDaoDto().getProgrammeExpencesFooter(uid);
//	}
//
//	@Override
//	public DtoChartProgrammes getProgrammeChart() {
//		return getDaoDto().getProgrammeChart();
//	}

//	@Override
//	public List<DtoProgrammeFinancialSource> getProgrammeFinanceDto(Long uid) {
//		return getDaoDtoFinance().getProgrammeFinanceDto(uid);
//	}

//	@Override
//	public DtoProgrammeFinancialSource getProgrammeFinanceFooterDto(Long uid) {
//		int num = 0;
//		try {
//			num = ((RebalancesCount)serviceReabalanceCount.findOne(new Long(1))).getRebalancesCount();
//		} catch (NullPointerException ex) {}
//		return getDaoDtoFinance().getProgrammeFinanceFooterDto(uid, num);
//	}

}

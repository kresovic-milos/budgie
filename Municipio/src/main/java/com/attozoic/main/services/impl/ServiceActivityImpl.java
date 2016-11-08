package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoActivity;
import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.model.DtoActivityProject;
import com.attozoic.main.model.DtoProgrammeFinancialSource;
import com.attozoic.main.model.RebalancesCount;
import com.attozoic.main.services.ServiceActivity;
import com.attozoic.main.services.ServiceRebalancesCount;

@Service
public class ServiceActivityImpl extends ServiceEntityImpl implements ServiceActivity {

	@Autowired
	private DaoActivity daoActivity;
	
	@Override
	public DaoEntity getDaoEntity() {
		return daoActivity;
	}
	
	@Autowired
	private ServiceRebalancesCount serviceRebalanceCount;
	
	@Override
	public ActivityGoal addActivityGoal(Long uid, ActivityGoal activityGoal) {
		return ((DaoActivity) getDaoEntity()).addActivityGoal(uid, activityGoal);
	}

	@Override
	public ActivityFinancialSource addActivityFinancialSource(Long uid, ActivityFinancialSource activityFinancialSource) {
		return ((DaoActivity) getDaoEntity()).addActivityFinancialSource(uid, activityFinancialSource);
	}

	@Override
	public ActivityEconomicAccount addActivityEconomicAccount(Long uid, ActivityEconomicAccount activityEconomicAccount) {
		return ((DaoActivity) getDaoEntity()).addActivityEconomicAccount(uid, activityEconomicAccount);
	}

	@Override
	public DtoActivityProject buildActivityDto(Long uid) {
		return ((DaoActivity) getDaoEntity()).buildActivityDto(uid);
	}

	@Override
	public DtoProgrammeFinancialSource buildActivityFinanceDto(Long uid) {
		int num = ((RebalancesCount)serviceRebalanceCount.findOne(new Long(1))).getRebalancesCount();
		return ((DaoActivity) getDaoEntity()).buildActivityFinanceDto(uid, num);
	}
	
}

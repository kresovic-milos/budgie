package com.attozoic.main.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoActivity;
import com.attozoic.main.dao.DaoActivityEconomicAccount;
import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.services.ServiceActivity;

@Service
public class ServiceActivityImpl extends ServiceEntityImpl implements ServiceActivity {

	@Autowired
	private DaoActivity daoActivity;
	
	@Override
	public DaoEntity getDaoEntity() {
		return daoActivity;
	}
	
	@Override
	public ActivityGoal addActivityGoal(Long uid, ActivityGoal activityGoal) {
		return ((DaoActivity) getDaoEntity()).addActivityGoal(uid, activityGoal);
	}

//	@Override
//	public ActivityFinancialSource addActivityFinancialSource(Long uid, ActivityFinancialSource activityFinancialSource) {
//		return ((DaoActivity) getDaoEntity()).addActivityFinancialSource(uid, activityFinancialSource);
//	}

	@Override
	public ActivityEconomicAccount addActivityEconomicAccount(Long uid, ActivityEconomicAccount activityEconomicAccount) {
		return ((DaoActivity) getDaoEntity()).addActivityEconomicAccount(uid, activityEconomicAccount);
	}
	
	@Override
	public Map<ActivityEconomicAccount, List<ActivityEconomicAccount>> getActivityEconomicAccountMap(Long uid) {
		return ((DaoActivity)getDaoEntity()).getActivityEconomicAccountMap(uid);
	}

//	@Override
//	public DtoProgrammeExpencesItem buildActivityDto(Long uid) {
//		return ((DaoActivity) getDaoEntity()).buildActivityDto(uid);
//	}

//	@Override
//	public DtoProgrammeFinancialSource buildActivityFinanceDto(Long uid) {
//		int num = 0;
//		try {
//			num = ((RebalancesCount)serviceRebalanceCount.findOne(new Long(1))).getRebalancesCount();
//		} catch (NullPointerException ex) {}
//		return ((DaoActivity) getDaoEntity()).buildActivityFinanceDto(uid, num);
//	}
	
}

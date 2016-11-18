package com.attozoic.main.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoActivity;
import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.model.SuperEconomicAccount;
import com.attozoic.main.model.dto.DtoActivityEconomicAccount;
import com.attozoic.main.model.dto.DtoFinanceFooter;
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
	public DtoFinanceFooter getActivityFinancialSourceFooter(Long uid) {
		return ((DaoActivity) getDaoEntity()).getActivityFinancialSourceFooter(uid);
	}
	
	@Override
	public Map<String, double[]> getActivityFinancialSourceMap(Long uid) {
		return ((DaoActivity) getDaoEntity()).getActivityFinancialSourceMap(uid);
	}
	
	@Override
	public SuperEconomicAccount getActivityEconomicAccountFooter(Long uid) {
		return ((DaoActivity) getDaoEntity()).getActivityEconomicAccountFooter(uid);
	}

	@Override
	public List<DtoActivityEconomicAccount> getActivityEconomicAccountDTOsList(Long uid) {
		return ((DaoActivity) getDaoEntity()).getActivityEconomicAccountDTOsList(uid);
	}
	
	@Override
	public ActivityGoal addActivityGoal(Long uid, ActivityGoal activityGoal) {
		return ((DaoActivity) getDaoEntity()).addActivityGoal(uid, activityGoal);
	}

	@Override
	public ActivityEconomicAccount addActivityEconomicAccount(Long uid, ActivityEconomicAccount activityEconomicAccount) {
		return ((DaoActivity) getDaoEntity()).addActivityEconomicAccount(uid, activityEconomicAccount);
	}
	
}

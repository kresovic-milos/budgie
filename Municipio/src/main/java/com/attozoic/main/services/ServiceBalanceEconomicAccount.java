package com.attozoic.main.services;

import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.ProjectFinancialSource;

public interface ServiceBalanceEconomicAccount extends ServiceEntity {
	
	ActivityFinancialSource addActivityFinancialSource(Long uid, ActivityFinancialSource acivityFinancialSource);
	ProjectFinancialSource addProjectFinancialSource(Long uid, ProjectFinancialSource projectFinancialSource);
}

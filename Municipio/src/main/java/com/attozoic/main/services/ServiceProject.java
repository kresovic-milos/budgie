package com.attozoic.main.services;

import com.attozoic.main.model.ProjectFinancialSource;
import com.attozoic.main.model.ProjectGoal;

public interface ServiceProject extends ServiceEntity {

	ProjectFinancialSource addFinancialSource(Long uid, ProjectFinancialSource financialSource);
	ProjectGoal addGoal(Long uid, ProjectGoal goal);

}

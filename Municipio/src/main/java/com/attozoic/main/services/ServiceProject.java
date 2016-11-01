package com.attozoic.main.services;

import com.attozoic.main.model.Authority;
import com.attozoic.main.model.EconomicAccount;
import com.attozoic.main.model.Function;
import com.attozoic.main.model.Head;
import com.attozoic.main.model.ProjectFinancialSource;
import com.attozoic.main.model.ProjectGoal;

public interface ServiceProject extends ServiceEntity {

	ProjectFinancialSource addFinancialSource(Long uid, ProjectFinancialSource financialSource);
	ProjectGoal addGoal(Long uid, ProjectGoal goal);
	Function addFunction(Long uid, Function function);
	Head addHead(Long uid, Head head);
	Authority addAuthority(Long uid, Authority authority);
	EconomicAccount addEconomicAccount(Long uid, EconomicAccount economiAccount);
}

package com.attozoic.main.services;

import java.util.List;

import com.attozoic.main.model.SuperFinancialSource;

public interface ServiceBalance extends ServiceEntity {
	
	SuperFinancialSource addSuperFinancialSource(Long uid, SuperFinancialSource superFinancialSource);
	List<SuperFinancialSource> getFinancialSources(Long uid);
}

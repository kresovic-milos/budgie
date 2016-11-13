package com.attozoic.main.services;

import com.attozoic.main.model.SuperFinancialSource;

public interface ServiceBalance extends ServiceEntity {
	
	SuperFinancialSource addQuarter1(Long uid, SuperFinancialSource superFinancialSource);
	SuperFinancialSource addQuarter2(Long uid, SuperFinancialSource superFinancialSource);
	SuperFinancialSource addQuarter3(Long uid, SuperFinancialSource superFinancialSource);
	SuperFinancialSource addQuarter4(Long uid, SuperFinancialSource superFinancialSource);
}

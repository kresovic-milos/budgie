package com.attozoic.main.services;

import com.attozoic.main.model.SuperFinancialSource;

public interface ServiceBalance extends ServiceEntity {
	
	SuperFinancialSource addSuperFinancialSource(Long uid, SuperFinancialSource superFinancialSource);
}

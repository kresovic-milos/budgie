package com.attozoic.main.services;

import org.springframework.data.domain.Page;

import com.attozoic.main.model.FinancialSource;

public interface ServiceFinancialSource {

	Page<FinancialSource> findAll();
	FinancialSource save(FinancialSource finance);

}

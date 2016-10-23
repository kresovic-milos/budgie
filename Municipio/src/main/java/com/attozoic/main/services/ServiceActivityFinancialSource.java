package com.attozoic.main.services;

import org.springframework.data.domain.Page;

import com.attozoic.main.model.ActivityFinancialSource;

public interface ServiceActivityFinancialSource {

	Page<ActivityFinancialSource> findAll();
	ActivityFinancialSource save(ActivityFinancialSource finance);

}

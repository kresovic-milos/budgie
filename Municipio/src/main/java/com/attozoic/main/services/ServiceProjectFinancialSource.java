package com.attozoic.main.services;

import org.springframework.data.domain.Page;

import com.attozoic.main.model.ProjectFinancialSource;

public interface ServiceProjectFinancialSource {

	Page<ProjectFinancialSource> findAll();
	ProjectFinancialSource save(ProjectFinancialSource finance);

}

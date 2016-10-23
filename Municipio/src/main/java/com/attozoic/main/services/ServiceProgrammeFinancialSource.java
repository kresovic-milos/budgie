package com.attozoic.main.services;

import org.springframework.data.domain.Page;

import com.attozoic.main.model.ProgrammeFinancialSource;

public interface ServiceProgrammeFinancialSource {

	Page<ProgrammeFinancialSource> findAll();
	ProgrammeFinancialSource save(ProgrammeFinancialSource finance);

}

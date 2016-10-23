package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProgrammeFinancialSource;
import com.attozoic.main.repositories.RepositoryProgrammeFinancialSource;

@Repository
public class DaoProgrammeFinancialSource {

	@Autowired
	private RepositoryProgrammeFinancialSource repoProgrammeFinancialSources;
	
	public Page<ProgrammeFinancialSource> findAll() {
		Page<ProgrammeFinancialSource> page = new PageImpl<>(repoProgrammeFinancialSources.findAll());
		return page;
	}
	
	public ProgrammeFinancialSource save(ProgrammeFinancialSource financialSource) {
		return repoProgrammeFinancialSources.save(financialSource);
	}
	
}

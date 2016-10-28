package com.attozoic.categories.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.repositories.RepositoryCategoryEntity;
import com.attozoic.categories.repositories.RepositoryCategoryProgrammeGoalIndicator;

@Repository
public class DaoCategoryProgrammeGoalIndicator extends DaoCategoryEntity {

	@Autowired
	private RepositoryCategoryProgrammeGoalIndicator repoProgrammeGoalIndicator;

	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryCategoryEntity getCategoryRepoEntity() {
		return repoProgrammeGoalIndicator;
	}
	
}

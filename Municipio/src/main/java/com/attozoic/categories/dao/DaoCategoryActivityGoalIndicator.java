package com.attozoic.categories.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.repositories.RepositoryCategoryActivityGoalIndicator;
import com.attozoic.categories.repositories.RepositoryCategoryEntity;

@Repository
public class DaoCategoryActivityGoalIndicator extends DaoCategoryEntity {

	@Autowired
	private RepositoryCategoryActivityGoalIndicator repoActivityGoalIndicator;

	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryCategoryEntity getCategoryRepoEntity() {
		return repoActivityGoalIndicator;
	}

}

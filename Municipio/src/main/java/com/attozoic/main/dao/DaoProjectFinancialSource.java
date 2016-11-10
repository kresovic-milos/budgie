package com.attozoic.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProjectFinancialSource;
import com.attozoic.main.model.RebalanceOneField;
import com.attozoic.main.model.RebalancesCount;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProjectFinancialSource;
import com.attozoic.main.repositories.RepositoryRebalancesCount;

@Repository
public class DaoProjectFinancialSource extends DaoEntity {

	@Autowired
	private RepositoryProjectFinancialSource repo;
	
	@Autowired
	private RepositoryRebalancesCount repoRebalanceCount;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repo;
	}
	
	@Override
	public SuperEntity update(SuperEntity superEntity) {
		ProjectFinancialSource projectFinancialSource = (ProjectFinancialSource) superEntity;
		projectFinancialSource.setSumSources123(projectFinancialSource.getSourceBaseYearPlus1() + projectFinancialSource.getSourceBaseYearPlus2() + projectFinancialSource.getSourceBaseYearPlus3());
		try {
			RebalancesCount rc = repoRebalanceCount.findOne(new Long(1));
			int numReb = rc.getRebalancesCount();
			if (numReb > 0) {
				List<RebalanceOneField> l = projectFinancialSource.getRebalances();
				for (int i = 0; i < l.size(); i++) {
					projectFinancialSource.setSumSources123(projectFinancialSource.getSumSources123() + l.get(i).getValue());
				}
			}
		} catch (NullPointerException ex) {}
		return super.update(projectFinancialSource);
	}
	
}

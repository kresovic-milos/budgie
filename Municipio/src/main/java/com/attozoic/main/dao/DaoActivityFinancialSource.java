package com.attozoic.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.RebalanceOneField;
import com.attozoic.main.model.RebalancesCount;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.repositories.RepositoryActivityFinancialSource;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryRebalancesCount;

@Repository
public class DaoActivityFinancialSource extends DaoEntity {

	@Autowired
	private RepositoryActivityFinancialSource repo;
	
	@Autowired
	private RepositoryRebalancesCount repoRebalanceCount;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repo;
	}
	
	@Override
	public SuperEntity update(SuperEntity superEntity) {
		ActivityFinancialSource activityFinancialSource = (ActivityFinancialSource) superEntity;
		activityFinancialSource.setSumSources123(activityFinancialSource.getSourceBaseYearPlus1() + activityFinancialSource.getSourceBaseYearPlus2() + activityFinancialSource.getSourceBaseYearPlus3());
		try {
			RebalancesCount rc = repoRebalanceCount.findOne(new Long(1));
			int numReb = rc.getRebalancesCount();
			if (numReb > 0) {
				List<RebalanceOneField> l = activityFinancialSource.getRebalances();
				for (int i = 0; i < l.size(); i++) {
					activityFinancialSource.setSumSources123(activityFinancialSource.getSumSources123() + l.get(i).getValue());
				}
			}
		} catch (NullPointerException ex) {}
		return super.update(activityFinancialSource);
	}
	
}

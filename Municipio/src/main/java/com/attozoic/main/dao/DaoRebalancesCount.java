package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.RebalancesCount;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryRebalancesCount;

@Repository
public class DaoRebalancesCount extends DaoEntity {

	@Autowired
	private RepositoryRebalancesCount repoRebalancesCount;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoRebalancesCount;
	}
	
	public int rebalancePlus() {
		RebalancesCount rc = repoRebalancesCount.findOne(1L);
		int number = rc.getRebalancesCount();
		rc.setRebalancesCount(number+1);
		repoRebalancesCount.save(rc);
		return rc.getRebalancesCount();
	}

	public int rebalanceMinus(Long uid) {
		RebalancesCount rc = repoRebalancesCount.findOne(uid);
		if (rc.getRebalancesCount()>0) {
			rc.setRebalancesCount(rc.getRebalancesCount()-1);
			repoRebalancesCount.save(rc);
		}
		return rc.getRebalancesCount();
	}
	
}

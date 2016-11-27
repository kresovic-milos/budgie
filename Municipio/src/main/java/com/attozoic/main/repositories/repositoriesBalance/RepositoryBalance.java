package com.attozoic.main.repositories.repositoriesBalance;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.SuperFinancialSource;
import com.attozoic.main.model.balance.Balance;
import com.attozoic.main.repositories.RepositoryEntity;

@Repository
public interface RepositoryBalance extends RepositoryEntity<Balance> {
	
	@Query("from SuperFinancialSource finSrc where finSrc.balance.uid=:balanceUid and finSrc.activeState = 0")
	public List<SuperFinancialSource> getBalanceFinancialSources(@Param("balanceUid") Long uid);
}

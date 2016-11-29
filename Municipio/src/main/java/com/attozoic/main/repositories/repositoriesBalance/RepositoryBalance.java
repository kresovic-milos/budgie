package com.attozoic.main.repositories.repositoriesBalance;

import java.util.List;

//import org.springframework.data.jpa.repository.Modifying;
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

	@Query("select SUM(b.balance_amount) from Balance b where b.activeState = 0 and b.year = 2016 and b.balanceType = 0")
	public double sum2016Budget();

	@Query("select SUM(b.balance_amount) from Balance b where b.activeState = 0 and b.year = 2016 and b.balanceType = 1")
	public double sum2016Others();
	
	//@Modifying
	//@Query("UPDATE Balance b SET b.balance_amount = :amount WHERE b.uid = :balanceUid")
	//public void updateBalanceAmount(@Param("amount") Double amount, @Param("balanceUid") Long uid);
	
}

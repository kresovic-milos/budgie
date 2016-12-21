package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActivityFinancialSource;

@Repository
public interface RepositoryActivityFinancialSource extends RepositoryEntity<ActivityFinancialSource> {
	
	@Query("FROM ActivityFinancialSource fs WHERE fs.balance.uid=:balanceUid")
	public List<ActivityFinancialSource> getFinancialSources(@Param("balanceUid") Long balanceUid);
}

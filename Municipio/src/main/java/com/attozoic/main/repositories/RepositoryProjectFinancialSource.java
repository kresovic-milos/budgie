package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProjectFinancialSource;

@Repository
public interface RepositoryProjectFinancialSource extends RepositoryEntity<ProjectFinancialSource> {
	
	@Query("FROM ProjectFinancialSource fs WHERE fs.balance.uid=:balanceUid")
	public List<ProjectFinancialSource> getFinancialSources(@Param("balanceUid") Long balanceUid);
}

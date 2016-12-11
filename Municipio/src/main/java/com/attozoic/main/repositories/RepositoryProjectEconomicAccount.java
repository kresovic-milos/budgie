package com.attozoic.main.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProjectEconomicAccount;

@Repository
public interface RepositoryProjectEconomicAccount extends RepositoryEntity<ProjectEconomicAccount> {
	
	@Query(value="SELECT COALESCE(SUM(sfs.amount), 0) AS total FROM ProjectEconomicAccount AS pea LEFT JOIN pea.balances AS b LEFT JOIN b.financialSources AS sfs WHERE SUBSTRING(pea.code,1,3)=411 AND pea.activeState=0 AND b.activeState=0 AND b.year=2017 AND b.balanceType=0 and sfs.activeState = 0")
	public double get411Sum();
	
	@Query(value="SELECT COALESCE(SUM(sfs.amount), 0) AS total FROM ProjectEconomicAccount AS pea LEFT JOIN pea.balances AS b LEFT JOIN b.financialSources AS sfs WHERE SUBSTRING(pea.code,1,3)=412 AND pea.activeState=0 AND b.activeState=0 AND b.year=2017 AND b.balanceType=0 and sfs.activeState = 0")
	public double get412Sum();
	
}

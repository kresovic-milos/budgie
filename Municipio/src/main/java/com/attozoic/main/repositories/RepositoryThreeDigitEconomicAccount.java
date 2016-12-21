package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ThreeDigitEconomicAccount;

@Repository
public interface RepositoryThreeDigitEconomicAccount extends RepositoryEntity<ThreeDigitEconomicAccount> {

	@Query("FROM ThreeDigitEconomicAccount AS t WHERE t.type = 'activity' AND t.itemUid=:itemUid") 
	public List<ThreeDigitEconomicAccount> getActivityThreeDigitEconomicAccounts(@Param("itemUid") Long itemUid);
	
	@Query("FROM ThreeDigitEconomicAccount AS t WHERE t.type = 'project' AND t.itemUid=:itemUid") 
	public List<ThreeDigitEconomicAccount> getProjectThreeDigitEconomicAccounts(@Param("itemUid") Long itemUid);
	
}

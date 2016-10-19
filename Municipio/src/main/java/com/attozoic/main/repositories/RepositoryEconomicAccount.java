package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.EconomicAccount;

@Repository
public interface RepositoryEconomicAccount extends CrudRepository<EconomicAccount, Long> {

	List<EconomicAccount> findAll();
	@SuppressWarnings("unchecked")
	EconomicAccount save(EconomicAccount economicAccount);
	
}

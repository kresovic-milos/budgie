package com.attozoic.categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryEconomicAccount;

@Repository
public interface RepositoryCategoryEconomicAccount extends CrudRepository<CategoryEconomicAccount, Long> {

	List<CategoryEconomicAccount> findAll();
	@SuppressWarnings("unchecked")
	CategoryEconomicAccount save(CategoryEconomicAccount economy);
	
}

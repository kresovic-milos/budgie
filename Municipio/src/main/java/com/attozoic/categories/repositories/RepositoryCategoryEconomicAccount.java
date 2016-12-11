package com.attozoic.categories.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryEconomicAccount;

@Repository
public interface RepositoryCategoryEconomicAccount extends RepositoryCategoryEntity<CategoryEconomicAccount> {

	@Query("SELECT SUBSTRING(c.code,1,3), name FROM CategoryEconomicAccount AS c WHERE SUBSTRING(c.code,4,6)=000")
	public List<Object> getThreeDigits();

	@Query("SELECT SUBSTRING(c.code,1,2), name FROM CategoryEconomicAccount AS c WHERE SUBSTRING(c.code,3,6)=0000")
	public List<Object> getTwoDigits();
	
	@Query("SELECT SUBSTRING(c.code,1,1), name FROM CategoryEconomicAccount AS c WHERE SUBSTRING(c.code,2,6)=00000")
	public List<Object> getOneDigits();

}

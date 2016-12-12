package com.attozoic.categories.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryFunction;

@Repository
public interface RepositoryCategoryFunction extends RepositoryCategoryEntity<CategoryFunction> {
	
	@Query("SELECT f.code, name FROM CategoryFunction AS f WHERE SUBSTRING(f.code,2,2)=00")
	public List<Object> getOneDigits();
}
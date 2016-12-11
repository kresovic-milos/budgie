package com.attozoic.categories.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryHead;

@Repository
public interface RepositoryCategoryHead extends RepositoryCategoryEntity<CategoryHead> {
	
	@Query("SELECT code, name FROM CategoryHead AS ch ORDER BY code ASC")
	public List<Object> getHeadsMap();
}

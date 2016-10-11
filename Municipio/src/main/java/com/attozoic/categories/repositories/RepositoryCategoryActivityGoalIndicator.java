package com.attozoic.categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryActivityGoalIndicator;

@Repository
public interface RepositoryCategoryActivityGoalIndicator extends CrudRepository<CategoryActivityGoalIndicator, Long>{

	List<CategoryActivityGoalIndicator> findAll();
	@SuppressWarnings("unchecked")
	CategoryActivityGoalIndicator save(CategoryActivityGoalIndicator indicator);
}

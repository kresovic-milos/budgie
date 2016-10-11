package com.attozoic.categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryActivityGoal;

@Repository
public interface RepositoryCategoryActivityGoal extends CrudRepository<CategoryActivityGoal, Long> {

	List<CategoryActivityGoal> findAll();
	@SuppressWarnings("unchecked")
	CategoryActivityGoal save(CategoryActivityGoal activityGoal);
}

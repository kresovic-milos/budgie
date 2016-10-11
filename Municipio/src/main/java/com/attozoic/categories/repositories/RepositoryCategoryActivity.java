package com.attozoic.categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryActivity;

@Repository
public interface RepositoryCategoryActivity extends CrudRepository<CategoryActivity, Long> {

	List<CategoryActivity> findAll();
	@SuppressWarnings("unchecked")
	CategoryActivity save(CategoryActivity activity);
}

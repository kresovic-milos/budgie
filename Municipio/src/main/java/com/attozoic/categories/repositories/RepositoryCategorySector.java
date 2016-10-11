package com.attozoic.categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategorySector;

@Repository
public interface RepositoryCategorySector extends CrudRepository<CategorySector, Long> {

	List<CategorySector> findAll();
	@SuppressWarnings("unchecked")
	CategorySector save(CategorySector sector);
}

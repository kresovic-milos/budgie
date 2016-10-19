package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Function;

@Repository
public interface RepositoryFunction extends CrudRepository<Function, Long> {

	List<Function> findAll();
	@SuppressWarnings("unchecked")
	Function save(Function function);
	
}
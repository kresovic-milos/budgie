package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Programme;

@Repository
public interface RepositoryProgramme extends CrudRepository<Programme, Long> {

	List<Programme> findAll();
	Programme findOne(Long uid);
	@SuppressWarnings("unchecked")
	Programme save(Programme programme);
	void delete(Long uid);
	
}

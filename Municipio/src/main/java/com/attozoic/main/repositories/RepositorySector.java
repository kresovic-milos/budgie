package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Sector;

@Repository
public interface RepositorySector extends CrudRepository<Sector, Long> {

	List<Sector> findAll();
	@SuppressWarnings("unchecked")
	Sector save(Sector sector);
}

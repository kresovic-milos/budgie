package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Sector;
import com.attozoic.main.repositories.RepositorySector;

@Repository
public class DaoSector {

	@Autowired
	private RepositorySector repoSector;
	
	public Page<Sector> findAll() {
		Page<Sector> page = new PageImpl<>(repoSector.findAll());
		return page;
	}

	public Sector save(Sector sector) {
		return repoSector.save(sector);
	}
}

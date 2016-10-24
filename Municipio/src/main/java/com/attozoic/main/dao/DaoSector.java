package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Programme;
import com.attozoic.main.model.Sector;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositorySector;

@Repository
public class DaoSector extends DaoEntity {

	@Autowired
	private RepositorySector repo;
	
	@Override
	public RepositoryEntity getRepoEntity() {
		return repo;
	}
	
	public Programme addProgramme(Long uid, Programme programme) {
		Sector sector = (Sector) getRepoEntity().findOne(uid);
		programme.setSector(sector);
		return (Programme) getRepoEntity().save(programme);
	}
	
}

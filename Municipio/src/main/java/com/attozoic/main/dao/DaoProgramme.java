package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Programme;
import com.attozoic.main.repositories.RepositoryProgramme;

@Repository
public class DaoProgramme {

	@Autowired
	private RepositoryProgramme repoProgramme;
	
	public Page<Programme> findAll() {
		Page<Programme> page = new PageImpl<>(repoProgramme.findAll());
		return page;
	}
	
	public Programme save(Programme programme) {
		return repoProgramme.save(programme);
	}
	
}

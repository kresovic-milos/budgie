package com.attozoic.main.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Programme;
import com.attozoic.main.model.Sector;

@Repository
public class DaoSector extends DaoEntity {

	public Programme addProgramme(Long uid, Programme programme) {
		Sector sector = (Sector) getRepoEntity().findOne(uid);
		List<Programme> programmes = sector.getProgrammes();
		programmes.add(programme);
		sector.setProgrammes(programmes);
		getRepoEntity().save(sector);
		return programme;
	}
	
}

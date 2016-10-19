package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoProgramme;
import com.attozoic.main.model.Programme;
import com.attozoic.main.services.ServiceProgramme;

@Service
public class ServiceProgrammeImpl implements ServiceProgramme {

	@Autowired
	private DaoProgramme daoProgramme;

	@Override
	public Page<Programme> findAll() {
		return daoProgramme.findAll();
	}

	@Override
	public Programme save(Programme programme) {
		return daoProgramme.save(programme);
	}
	
}

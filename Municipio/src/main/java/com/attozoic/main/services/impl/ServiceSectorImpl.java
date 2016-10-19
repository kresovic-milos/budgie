package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoSector;
import com.attozoic.main.model.Sector;
import com.attozoic.main.services.ServiceSector;

@Service
public class ServiceSectorImpl implements ServiceSector {

	@Autowired
	private DaoSector daoSector;
	
	@Override
	public Page<Sector> findAll() {
		return daoSector.findAll();
	}

	@Override
	public Sector save(Sector sector) {
		return daoSector.save(sector);
	}
}

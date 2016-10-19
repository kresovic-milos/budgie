package com.attozoic.main.services;

import org.springframework.data.domain.Page;

import com.attozoic.main.model.Sector;

public interface ServiceSector {
	Page<Sector> findAll();
	Sector save(Sector sector);
}

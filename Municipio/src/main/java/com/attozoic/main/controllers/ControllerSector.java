package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.Sector;
import com.attozoic.main.services.ServiceSector;

@RestController
@RequestMapping("/sectors")
public class ControllerSector {

	@Autowired
	private ServiceSector serviceSector;

	@RequestMapping(method = RequestMethod.GET)
	public Page<Sector> getAllSectors() {
		return serviceSector.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Sector addSector(@RequestBody Sector sector) {
		return serviceSector.save(sector);
	}
	
}

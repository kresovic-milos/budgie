package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.Sector;
import com.attozoic.main.services.ServiceSector;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/sectors")
public class ControllerSector {

	@Autowired
	private ServiceSector serviceSector;

	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<Sector> getAllSectors() {
		return serviceSector.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Sector addSector(@RequestBody Sector sector) {
		return serviceSector.save(sector);
	}
	
}
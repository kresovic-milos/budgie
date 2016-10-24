package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.ActiveState;
import com.attozoic.main.model.Programme;
import com.attozoic.main.model.Sector;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.services.ServiceSector;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/sectors")
public class ControllerSector {

	@Autowired
	private ServiceSector serviceSector;

	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getAllSectors() {
		return serviceSector.findAll();
	}
	
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getSector(@PathVariable(value="uid") Long uid) {
		return serviceSector.findOne(uid);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Sector addSector(@RequestBody Sector sector) {
		sector.setActiveState(ActiveState.ACTIVE);
		return (Sector) serviceSector.save(sector);
	}
	
	@RequestMapping(value="/{uid}/programme", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Programme addProgramme(@PathVariable(value="uid") Long uid, @RequestBody Programme programme) {
		programme.setActiveState(ActiveState.ACTIVE);
		return serviceSector.addProgramme(uid, programme);
	}
}

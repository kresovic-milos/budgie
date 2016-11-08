package com.attozoic.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
	//addAllSectors (like categorySectors)
	@RequestMapping(value="/addAll", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addAllSectors(@RequestBody List<Sector> sectors) {
		for (Sector sector : sectors) {
			serviceSector.save(sector);
		}
	}
	
	//getAllSectors
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getAllSectors() {
		return serviceSector.findAll();
	}
	
	//getSector{uid}
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getSector(@PathVariable(value="uid") Long uid) {
		return serviceSector.findOne(uid);
	}
	
	//getActiveSectors
	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveSectors() {
		return serviceSector.findActive();
	}
	
	//getArchivedSectors
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedSectors() {
		return serviceSector.findArchived();
	}
	
	//addOneNewSector if new categorySector exist
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Sector addSector(@RequestBody Sector sector) {
		return (Sector) serviceSector.save(sector);
	}
	
	//updateSector
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Sector update(@RequestBody Sector sector) {
		return (Sector) serviceSector.update(sector);
	}
	
	//deleteSector{uid}
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceSector.delete(uid);
	}
	
	//archiveSector{uid}
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceSector.archive(uid);
	}
	
	//unarchiveSector{uid}
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceSector.unarchive(uid);
	}
	
	//addProgramme to Sector{uid}
	@RequestMapping(value="/{uid}/programmes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Programme addProgramme(@PathVariable(value="uid") Long uid, @RequestBody Programme programme) {
		return serviceSector.addProgramme(uid, programme);
	}
	
}

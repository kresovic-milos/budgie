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

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.Programme;
import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.model.Project;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.model.dto.DtoProgrammeEconomicAccount;
import com.attozoic.main.model.dto.DtoProgrammeFinances;
import com.attozoic.main.services.ServiceProgramme;

@RestController
@RequestMapping("/programmes")
public class ControllerProgramme {

	@Autowired
	private ServiceProgramme serviceProgramme;
	
	// GRAFIKON
	@RequestMapping(value="/{year}/chartQ", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Object> getChart(@PathVariable(value="year") double year) {
		return serviceProgramme.getChart(year);
	}
	
	//getProgrammeGoals{uid}
	@RequestMapping(value="/{uid}/goals", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<ProgrammeGoal> getProgrammeGoals(@PathVariable(value="uid") Long uid) {
		return serviceProgramme.getProgrammeGoals(uid);
	}
	
	//GENERATE AMOUNTS
	@RequestMapping(value="/{uid}/generateBalances", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void generateBalancesAmounts(@PathVariable(value="uid") Long uid) {
		serviceProgramme.generateBalancesAmounts(uid);
	}
	
	//getProgrammeFinancialSourceFooter{uid}
//	@RequestMapping(value="/{uid}/financesFooter", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public DtoProgrammeFinances getProgrammeFinancialSourceFooter(@PathVariable(value="uid") Long uid) {
//		return serviceProgramme.getProgrammeFinancialSourceFooter(uid);
//	}
	
	//getProgrammeFinances{uid}
	@RequestMapping(value="/{uid}/finances", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DtoProgrammeFinances getProgrammeFinances(@PathVariable(value="uid") Long uid) {
		return serviceProgramme.getProgrammeFinances(uid);
	}
	
	//getProgrammeEconomicAccountFooter{uid}
	@RequestMapping(value="/{uid}/expencesFooter", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DtoProgrammeEconomicAccount getProgrammeEconomicAccountFooter(@PathVariable(value="uid") Long uid) {
		return serviceProgramme.getProgrammeEconomicAccountFooter(uid);
	}
	
	//getProgrammeEconomicAccountList{uid}
	@RequestMapping(value="/{uid}/expences", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<DtoProgrammeEconomicAccount> getProgrammeEconomicAccountList(@PathVariable(value="uid") Long uid) {
		return serviceProgramme.getProgrammeEconomicAccountList(uid);
	}
	
	//addProgrammeGoal to Programme{uid}
	@RequestMapping(value="/{uid}/programmeGoals", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProgrammeGoal addProgrammeGoal(@PathVariable(value="uid") Long uid, @RequestBody ProgrammeGoal programmeGoal) {
		return serviceProgramme.addProgrammeGoal(uid, programmeGoal);
	}
	
	//addActivity to Programme{uid}
	@RequestMapping(value="/{uid}/activities", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Activity addActivity(@PathVariable(value="uid") Long uid, @RequestBody Activity activity) {
		return serviceProgramme.addActivity(uid, activity);
	}
	
	//addProject to Programme{uid}
	@RequestMapping(value="/{uid}/projects", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Project addProject(@PathVariable(value="uid") Long uid, @RequestBody Project project) {
		return serviceProgramme.addProject(uid, project);
	}
	
	//getAllProgrammes
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public Page<SuperEntity> getAllProgrammes() {
		return serviceProgramme.findAll();
	}
	
	//getProgramme{uid}
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getProgramme(@PathVariable(value="uid") Long uid) {
		return serviceProgramme.findOne(uid);
	}
	
	//getActiveProgrammes
	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveProgrammes() {
		return serviceProgramme.findActive();
	}
	
	//getArchivedProgrammes
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedProgrammes() {
		return serviceProgramme.findArchived();
	}
	
//	//saveProgramme
//	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public Programme save(@RequestBody Programme programme) {
//		return (Programme) serviceProgramme.save(programme);
//	}
	
	//updateProgramme
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Programme update(@RequestBody Programme programme) {
		return (Programme) serviceProgramme.update(programme);
	}
	
	//deleteProgramme{uid}
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceProgramme.delete(uid);
	}
	
	//archiveProgramme{uid}
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceProgramme.archive(uid);
	}
	
	//unarchiveProgramme{uid}
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceProgramme.unarchive(uid);
	}

}

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

import com.attozoic.main.model.ActiveState;
import com.attozoic.main.model.Activity;
import com.attozoic.main.model.DtoActivityProject;
import com.attozoic.main.model.DtoProgrammeChart;
import com.attozoic.main.model.DtoProgrammeFinancialSource;
import com.attozoic.main.model.Programme;
import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.model.Project;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.services.ServiceProgramme;

@RestController
@RequestMapping("/programmes")
public class ControllerProgramme {

	@Autowired
	private ServiceProgramme serviceProgramme;
	
	//getDtoProgramme{uid} - One ProgrammeDTO
	@RequestMapping(value="/{uid}/programmeFooterDto", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DtoActivityProject getDTOProgramme(@PathVariable(value="uid") Long uid) {
		return serviceProgramme.getDtoProgramme(uid);
	}
	
	//getProgramme{uid}DTOs - ActivityDTOs & ProjectDTOs
	@RequestMapping(value="/{uid}/programeDtos", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<DtoActivityProject> getProgrammeDTOs(@PathVariable(value="uid") Long uid) {
		return serviceProgramme.getProgrammeDTOs(uid);
	}
	
	//getProgramme{uid}FinanceDTOs - ActivityFinSrcDTOs & ProjectFinSrcDTOs
	@RequestMapping(value="/{uid}/programmeFinanceDto", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<DtoProgrammeFinancialSource> getProgrammeFinanceDTOs(@PathVariable(value="uid") Long uid) {
		return serviceProgramme.getProgrammeFinanceDto(uid);
	}
	
	//getProgrammeChart
	@RequestMapping(value="/dtoChart", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DtoProgrammeChart getProgrammeChart() {
		return serviceProgramme.getProgrammeChart();
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
	
	//addProgrammeGoal to Programme{uid}
	@RequestMapping(value="/{uid}/programmeGoals", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProgrammeGoal addProgrammeGoal(@PathVariable(value="uid") Long uid, @RequestBody ProgrammeGoal programmeGoal) {
		programmeGoal.setActiveState(ActiveState.ACTIVE);
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

}

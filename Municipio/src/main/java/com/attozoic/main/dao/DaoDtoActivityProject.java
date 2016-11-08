package com.attozoic.main.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.DtoActivityProject;
import com.attozoic.main.model.DtoActivityProjectRebalanceObject;
import com.attozoic.main.model.DtoProgrammeChartObject;
import com.attozoic.main.model.Programme;
import com.attozoic.main.model.Project;
import com.attozoic.main.repositories.RepositoryProgramme;

@Repository
public class DaoDtoActivityProject {

	@Autowired
	private RepositoryProgramme repoProgramme;
	
	public List<DtoActivityProject> getProgrammeDTOs(Long uid) {
		HashMap<String, DtoActivityProject> dtoMap = new HashMap<>();
		Programme programme = repoProgramme.findOne(uid);
		List<Activity> acivities = programme.getActivities();
		for (Activity activity : acivities) {
			DtoActivityProject dto = activity.buildActivityDTO();			
			if (dtoMap.containsKey(activity.getCategoryName())) {
				dtoMap.get(activity.getCategoryName()).dtoPlusDto(dto);
			} else {
				dtoMap.put(activity.getCategoryName(), dto);
			}
		}
		List<Project> projects = programme.getProjects();
		for (Project project : projects) {
			DtoActivityProject dto = project.buildProjectDTO();
			dtoMap.put(project.getName(), dto);
		}
		return new ArrayList<DtoActivityProject>(dtoMap.values());
	}
	
	public DtoActivityProject dtoProgramme(Long uid) {
		Programme programme = repoProgramme.findOne(uid);
		DtoActivityProject dto = new DtoActivityProject();
		dto.setType("Програм");
		dto.setName(programme.getName());
		List<DtoActivityProject> list = getProgrammeDTOs(uid);
		for (DtoActivityProject dtoActivityProject : list) {
			dto.dtoPlusDto(dtoActivityProject);
		}
		return dto;
	}
	
	public List<DtoActivityProject> getAllProgrammeDTOs() {
		List<DtoActivityProject> programmeDTOs = new ArrayList<>();
		List<Programme> list = repoProgramme.findAll();
		for (Programme programme : list) {
			DtoActivityProject dto = dtoProgramme(programme.getUid());
			programmeDTOs.add(dto);
		}
		return programmeDTOs;
	}
	
	public List<DtoProgrammeChartObject> ProgrammeChartObjectList() {
		List<DtoProgrammeChartObject> list = new ArrayList<>();
		List<DtoProgrammeChartObject> l = fillProgrammeChartObjectList();
		double sum = sumValues100Percent(l);
		for (DtoProgrammeChartObject dtoProgrammeChartObject : l) {
			dtoProgrammeChartObject.setPercnetage((dtoProgrammeChartObject.getValue()/sum)*100);
			list.add(dtoProgrammeChartObject);
		}
		return list;
	}
	
	private List<DtoProgrammeChartObject> fillProgrammeChartObjectList() {
		List<DtoActivityProject> list = getAllProgrammeDTOs();
		List<DtoProgrammeChartObject> lpc = new ArrayList<>();
		for (DtoActivityProject dto : list) {
			DtoProgrammeChartObject dpc = new DtoProgrammeChartObject();
			dpc.setName(dto.getName());
			if (dto.getListDtoRebalances().isEmpty()) {
				dpc.setValue(dto.getSumExpensesBaseYearPlus1Budget());
			} else {
				List<DtoActivityProjectRebalanceObject> l = dto.getListDtoRebalances();
				dpc.setValue(l.get(l.size()-1).getSumValueB());
			}
			lpc.add(dpc);
		}
		return lpc;
	}
	
	private double sumValues100Percent(List<DtoProgrammeChartObject> l) {
		double sum = 0;
		for (DtoProgrammeChartObject dtoProgrammeChartObject : l) {
			sum += dtoProgrammeChartObject.getValue();
		}
		return sum;
	}
	
//	public void programmesChart() {
//		List<DtoProgrammeChart> dtoProgrammesChart = new ArrayList<>();
//		List<Programme> list = repoProgramme.findAll();
//		for (Programme programme : list) {
//			DtoProgrammeChart dtoP = new DtoProgrammeChart();
//			dtoP.setName(programme.getName());
//			List<DtoActivityProject> listDaoPAs = getProgrammeDTOs(programme.getUid());
//			for (DtoActivityProject dtoActivityProject : listDaoPAs) {
//				dtoActivityProject.getS
//			}
//		}
//	}
	
}

package com.attozoic.main.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.DtoActivityProject;
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
				dtoMap.get(activity.getCategoryName()).DtoPlusDto(dto);
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
	
}

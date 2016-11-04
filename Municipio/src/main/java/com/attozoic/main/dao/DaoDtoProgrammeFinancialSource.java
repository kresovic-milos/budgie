package com.attozoic.main.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.DtoProgrammeFinancialSource;
import com.attozoic.main.model.Programme;
import com.attozoic.main.model.Project;
import com.attozoic.main.repositories.RepositoryProgramme;

@Repository
public class DaoDtoProgrammeFinancialSource {

	@Autowired
	private RepositoryProgramme repoProgramme;
	
	public List<DtoProgrammeFinancialSource> getProgrammeFinanceDto(Long uid) {
		HashMap<String, DtoProgrammeFinancialSource> dtoMap = new HashMap<>();
		Programme programme = repoProgramme.findOne(uid);
		List<Activity> listActivities = programme.getActivities();
		for (Activity activity : listActivities) {
			List<DtoProgrammeFinancialSource> listFS = activity.buildDtoFinanceList();
			for (DtoProgrammeFinancialSource dtoProgrammeFinancialSource : listFS) {
				if (dtoMap.containsKey(dtoProgrammeFinancialSource.getName())) {
					dtoMap.get(dtoProgrammeFinancialSource.getName()).dtoFinancePlusDtoFinance(dtoProgrammeFinancialSource);
				} else {
					dtoMap.put(dtoProgrammeFinancialSource.getName(), dtoProgrammeFinancialSource);
				}
			}
		}
		List<Project> listProjects = programme.getProjects();
		for (Project project : listProjects) {
			List<DtoProgrammeFinancialSource> listFS = project.buildDtoFinanceList();
			for (DtoProgrammeFinancialSource dtoProgrammeFinancialSource : listFS) {
				if (dtoMap.containsKey(dtoProgrammeFinancialSource.getName())) {
					dtoMap.get(dtoProgrammeFinancialSource.getName()).dtoFinancePlusDtoFinance(dtoProgrammeFinancialSource);
				} else {
					dtoMap.put(dtoProgrammeFinancialSource.getName(), dtoProgrammeFinancialSource);
				}
			}
		}
		return new ArrayList<DtoProgrammeFinancialSource>(dtoMap.values());
	}
	
	
}

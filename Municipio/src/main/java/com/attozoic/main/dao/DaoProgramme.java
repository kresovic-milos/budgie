package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.Programme;
import com.attozoic.main.model.ProgrammeFinancialSource;
import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.model.Project;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProgramme;

@Repository
public class DaoProgramme extends DaoEntity {
	
	@Autowired
	private RepositoryProgramme repo;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repo;
	}
	
	@SuppressWarnings("unchecked")
	public ProgrammeGoal addProgrammeGoal(Long uid, ProgrammeGoal programmeGoal) {
		Programme programme = (Programme) getRepoEntity().findOne(uid);
		programmeGoal.setProgramme(programme);
		return (ProgrammeGoal) getRepoEntity().save(programmeGoal);
	}
	
	@SuppressWarnings("unchecked")
	public Activity addActivity(Long uid, Activity activity) {
		Programme programme = (Programme) getRepoEntity().findOne(uid);
		activity.setProgramme(programme);
		return (Activity) getRepoEntity().save(activity);
	}
	
	@SuppressWarnings("unchecked")
	public Project addProject(Long uid, Project project) {
		Programme programme = (Programme) getRepoEntity().findOne(uid);
		project.setProgramme(programme);
		return (Project) getRepoEntity().save(project);
	}
	
	@SuppressWarnings("unchecked")
	public ProgrammeFinancialSource addProgrammeFinancialSource(Long uid, ProgrammeFinancialSource programmeFinancialSource) {
		Programme programme = (Programme) getRepoEntity().findOne(uid);
		programmeFinancialSource.getProgrammes().add(programme);
		programme.getProgrammeFinancialSources().add(programmeFinancialSource);
		programmeFinancialSource.setSumSources123(programmeFinancialSource.getSourceBaseYear() + programmeFinancialSource.getSourceBaseYearPlus1() + programmeFinancialSource.getSourceBaseYearPlus2() + programmeFinancialSource.getSourceBaseYearPlus3());
		return (ProgrammeFinancialSource) getRepoEntity().save(programmeFinancialSource);
	}
	
}

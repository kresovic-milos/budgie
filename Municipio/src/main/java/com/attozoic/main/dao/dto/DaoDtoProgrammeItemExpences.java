package com.attozoic.main.dao.dto;

import org.springframework.stereotype.Repository;

@Repository
public class DaoDtoProgrammeItemExpences {

//	@Autowired
//	private RepositoryProgramme repoProgramme;
//	
//	// List<DtoProgrammeExpencesItem>
//	public List<DtoProgrammeExpencesItem> getProgrammeExpencesItems(Long uid) {
//		HashMap<String, DtoProgrammeExpencesItem> dtoMap = new HashMap<>();
//		Programme programme = repoProgramme.findOne(uid);
//		List<Activity> acivities = programme.getActivities();
//		for (Activity activity : acivities) {
//			DtoProgrammeExpencesItem dto = activity.buildDtoActivityExpences();		
//			if (dtoMap.containsKey(activity.getCategoryName())) {
//				dtoMap.get(activity.getCategoryName()).sumDtoProgrammeExpencesItems(dto);
//			} else {
//				dtoMap.put(activity.getCategoryName(), dto);
//			}
//		}
//		List<Project> projects = programme.getProjects();
//		for (Project project : projects) {
//			DtoProgrammeExpencesItem dto = project.buildDtoProjectExpences();
//			dtoMap.put(project.getName(), dto);
//		}
//		return new ArrayList<DtoProgrammeExpencesItem>(dtoMap.values());
//	}
//	
//	// DtoProgrammeExpencesItemFooter
//	public DtoProgrammeExpencesItem getProgrammeExpencesFooter(Long uid) {
//		Programme programme = repoProgramme.findOne(uid);
//		List<Activity> acivities = programme.getActivities();
//		DtoProgrammeExpencesItem dtoFooter = new DtoProgrammeExpencesItem();
//		dtoFooter.setName(programme.getName());
//		dtoFooter.setType("Програм");
//		for (Activity activity : acivities) {
//			DtoProgrammeExpencesItem dto = activity.buildDtoActivityExpences();
//			dtoFooter.sumDtoProgrammeExpencesItems(dto);
//		}
//		List<Project> projects = programme.getProjects();
//		for (Project project : projects) {
//			DtoProgrammeExpencesItem dto = project.buildDtoProjectExpences();
//			dtoFooter.sumDtoProgrammeExpencesItems(dto);
//		}
//		return dtoFooter;
//	}
//
//	// ProgrammesChart
//	public DtoChartProgrammes getProgrammeChart() {
//		DtoChartProgrammes dtoProgrammeChart = new DtoChartProgrammes();
//		List<DtoChartProgramme> list = new ArrayList<>();
//		List<DtoChartProgramme> l = getDtoChartProgrammeList();
//		double sum = sumValues100Percent(l);
//		for (DtoChartProgramme dtoProgrammeChartObject : l) {
//			dtoProgrammeChartObject.setPercnetage((dtoProgrammeChartObject.getValue()/sum)*100);
//			list.add(dtoProgrammeChartObject);
//		}
//		dtoProgrammeChart.setSum(sum);
//		dtoProgrammeChart.setList(list);
//		return dtoProgrammeChart;
//	}
//	
//	private List<DtoProgrammeExpencesItem> getProgrammeExpencesFooters() {
//		List<DtoProgrammeExpencesItem> programmeDTOs = new ArrayList<>();
//		List<Programme> list = repoProgramme.findAll();
//		for (Programme programme : list) {
//			DtoProgrammeExpencesItem dto = getProgrammeExpencesFooter(programme.getUid());
//			programmeDTOs.add(dto);
//		}
//		return programmeDTOs;
//	}
//	
//	private List<DtoChartProgramme> getDtoChartProgrammeList() {
//		List<DtoProgrammeExpencesItem> list = getProgrammeExpencesFooters();
//		List<DtoChartProgramme> lpc = new ArrayList<>();
//		for (DtoProgrammeExpencesItem dto : list) {
//			DtoChartProgramme dpc = new DtoChartProgramme();
//			dpc.setName(dto.getName());
//			if (dto.getDtoRebalanceTwoFieldsList().isEmpty()) {
//				dpc.setValue(dto.getSumExpensesBaseYearPlus1Budget());
//			} else {
//				List<DtoRebalanceTwoFields> l = dto.getDtoRebalanceTwoFieldsList();
//				dpc.setValue(l.get(l.size()-1).getSumValueB());
//			}
//			lpc.add(dpc);
//		}
//		return lpc;
//	}
//	
//	private double sumValues100Percent(List<DtoChartProgramme> l) {
//		double sum = 0;
//		for (DtoChartProgramme dtoProgrammeChartObject : l) {
//			sum += dtoProgrammeChartObject.getValue();
//		}
//		return sum;
//	}
	
}

package com.attozoic.main.dao.dto;

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//
//import com.attozoic.main.model.Activity;
//import com.attozoic.main.model.Programme;
//import com.attozoic.main.model.Project;
//import com.attozoic.main.model.dto.DtoProgrammeFinancialSourceItem;
//import com.attozoic.main.model.dto.DtoProgrammeFinancialSource;
//import com.attozoic.main.repositories.RepositoryProgramme;

@Repository
public class DaoDtoProgrammeFinancialSource {
//
//	@Autowired
//	private RepositoryProgramme repoProgramme;
//	
//	public List<DtoProgrammeFinancialSourceItem> getProgrammeFinances(Long uid) {
//		HashMap<String, DtoProgrammeFinancialSource> dtoMap = new HashMap<>();
//		Programme programme = repoProgramme.findOne(uid);
//		List<Activity> listActivities = programme.getActivities();
//		for (Activity activity : listActivities) {
//			List<DtoProgrammeFinancialSource> listFS = activity.buildDtoFinanceList();
//			for (DtoProgrammeFinancialSource dtoProgrammeFinancialSource : listFS) {
//				if (dtoMap.containsKey(dtoProgrammeFinancialSource.getName())) {
//					dtoMap.get(dtoProgrammeFinancialSource.getName()).dtoFinancePlusDtoFinance(dtoProgrammeFinancialSource);
//				} else {
//					dtoMap.put(dtoProgrammeFinancialSource.getName(), dtoProgrammeFinancialSource);
//				}
//			}
//		}
//		List<Project> listProjects = programme.getProjects();
//		for (Project project : listProjects) {
//			List<DtoProgrammeFinancialSource> listFS = project.buildDtoFinanceList();
//			for (DtoProgrammeFinancialSource dtoProgrammeFinancialSource : listFS) {
//				if (dtoMap.containsKey(dtoProgrammeFinancialSource.getName())) {
//					dtoMap.get(dtoProgrammeFinancialSource.getName()).dtoFinancePlusDtoFinance(dtoProgrammeFinancialSource);
//				} else {
//					dtoMap.put(dtoProgrammeFinancialSource.getName(), dtoProgrammeFinancialSource);
//				}
//			}
//		}
//		return new ArrayList<DtoProgrammeFinancialSource>(dtoMap.values());
//	}
//	
//	public DtoProgrammeFinancialSource getProgrammeFinanceFooterDto(Long uid, int num) {
//		DtoProgrammeFinancialSource dto = new DtoProgrammeFinancialSource();
//		dto.setName(repoProgramme.findOne(uid).getName());
//		if (num > 0) {
//			List<Double> l = new ArrayList<>();
//			for (int i = 0; i < num; i++) {
//				l.add(new Double(0));
//			}
//			dto.setListSourceRebalance(l);
//		}
//		List<DtoProgrammeFinancialSource> list = getProgrammeFinanceDto(uid);
//		for (DtoProgrammeFinancialSource dtoProgrammeFinancialSource : list) {
//			dto.dtoFinancePlusDtoFinance(dtoProgrammeFinancialSource);
//		}
//		return dto;
//	}
	
}

package com.attozoic.main.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.attozoic.main.model.dto.DtoFinanceFooter;
import com.attozoic.main.model.dto.DtoProgrammeChartObject;
import com.attozoic.main.model.dto.DtoProgrammeEconomicAccount;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="programmes")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=Programme.class)
public class Programme extends SuperEntity {
	
	private Long categoryID;
	
	private String code;
	private String ordNumber;
	@Column(length = 512)
	private String name; 
	@Column(length = 2048)
	private String purpose; 
	
    @Column(length = 2048)
	private String rudiment;
    @Column(length = 2048)
	private String description;
    @Column(length = 2048)
	private String budgetUser;
    @Column(length = 2048)
	private String responsibleAuthority;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sector_uid")
	@NotFound(action=NotFoundAction.IGNORE)
	@JsonIgnoreProperties({"categoryID", "programmes"}) 
    private Sector sector;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="programme")
	@JsonIgnore
	private List<ProgrammeGoal> programmeGoals = new ArrayList<>();
    
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="programme")
	private List<Activity> activities = new ArrayList<>();
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="programme")
	private List<Project> projects = new ArrayList<>();
	
	public Programme() {}
	
// // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
	
	// ProgrammeEconomicAccount LIST and FOOTER	
	
	// FOOTER of List of ProgrammeEconomicAccounts
	public DtoProgrammeEconomicAccount generateProgrammeEconomicAccountFooter(int numRebalances) {
		DtoProgrammeEconomicAccount programmeEconomicAccount = new DtoProgrammeEconomicAccount();
		programmeEconomicAccount.generateBalances(numRebalances);
		List<DtoProgrammeEconomicAccount> list = generateProgrammeEconomicAccountList(numRebalances);
		for (DtoProgrammeEconomicAccount dtoProgrammeEconomicAccount : list) {
			programmeEconomicAccount = programmeEconomicAccount.sumProgrammeEconomicAccounts(dtoProgrammeEconomicAccount);
		}
		return programmeEconomicAccount;
	}
	
	// List of ProgrammeEconomicAccounts (ActivityFooters and ProjectFooters)
	public List<DtoProgrammeEconomicAccount> generateProgrammeEconomicAccountList(int numRebalances) {
		Map<String, List<SuperEconomicAccount>> map = generateProgrammeEconomicAccountMap(numRebalances);
		List<DtoProgrammeEconomicAccount> programmeEconomicAccounts = new ArrayList<>();
		for (Map.Entry<String, List<SuperEconomicAccount>> entry : map.entrySet()) {
			SuperEconomicAccount superEconomicAccount;
			if (entry.getValue().get(0) instanceof ActivityEconomicAccount) {
				superEconomicAccount = new ActivityEconomicAccount();
				ActivityEconomicAccount activityEconomicAccount = (ActivityEconomicAccount)superEconomicAccount;
				activityEconomicAccount.generateBalances(numRebalances);
				for (SuperEconomicAccount superEconomicAccount2 : entry.getValue()) {
					ActivityEconomicAccount aea = (ActivityEconomicAccount)superEconomicAccount2;
					activityEconomicAccount = activityEconomicAccount.sumActivityEconomicAccounts(aea);
				}
				DtoProgrammeEconomicAccount programmeEconomicAccount = new DtoProgrammeEconomicAccount(entry.getKey(), activityEconomicAccount.getBalances());
				programmeEconomicAccount.generateSumExpences123();
				programmeEconomicAccounts.add(programmeEconomicAccount);
			} else {
				superEconomicAccount = new ProjectEconomicAccount();
				ProjectEconomicAccount projectEconomicAccount = (ProjectEconomicAccount)superEconomicAccount;
				projectEconomicAccount.generateBalances(numRebalances);
				for (SuperEconomicAccount superEconomicAccount2 : entry.getValue()) {
					ProjectEconomicAccount pea = (ProjectEconomicAccount)superEconomicAccount2;
					projectEconomicAccount = projectEconomicAccount.sumProjectEconomicAccounts(pea);
				}
				DtoProgrammeEconomicAccount programmeEconomicAccount = new DtoProgrammeEconomicAccount(entry.getKey(), projectEconomicAccount.getBalances());
				programmeEconomicAccount.generateSumExpences123();
				programmeEconomicAccounts.add(programmeEconomicAccount);
			}
		}
		return programmeEconomicAccounts;
	}
	
	private Map<String, List<SuperEconomicAccount>> generateProgrammeEconomicAccountMap(int numRebalances) {
		Map<String, List<SuperEconomicAccount>> map = new HashMap<>();
		for (Activity activity : activities) {
			SuperEconomicAccount superEconomicAccount = activity.generateActivityEconomicAccountFooter(numRebalances);
			if (map.containsKey(superEconomicAccount.getCategoryName())) {
				List<SuperEconomicAccount> superEconomicAccounts = map.get(superEconomicAccount.getCategoryName());
				superEconomicAccounts.add(superEconomicAccount);
				map.put(superEconomicAccount.getCategoryName(), superEconomicAccounts);
			} else {
				List<SuperEconomicAccount> superEconomicAccounts = new ArrayList<>();
				superEconomicAccounts.add(superEconomicAccount);
				map.put(superEconomicAccount.getCategoryName(), superEconomicAccounts);
			}
		}
		for (Project project : projects) {
			SuperEconomicAccount superEconomicAccount = project.generateProjectEconomicAccountFooter(numRebalances);
			if (map.containsKey(superEconomicAccount.getCategoryName())) {
				List<SuperEconomicAccount> superEconomicAccounts = map.get(superEconomicAccount.getCategoryName());
				superEconomicAccounts.add(superEconomicAccount);
				map.put(superEconomicAccount.getCategoryName(), superEconomicAccounts);
			} else {
				List<SuperEconomicAccount> superEconomicAccounts = new ArrayList<>();
				superEconomicAccounts.add(superEconomicAccount);
				map.put(superEconomicAccount.getCategoryName(), superEconomicAccounts);
			}
		}
		return map;
	}
	
// // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
	
	// ProgrammeFinancialSource LIST and FOOTER
	
	// generateProgrammeFinancialSourceMap
	public DtoFinanceFooter generateProgrammeFinancialSourceFooter() {
		Map<String, double[]> map = this.generateProgrammeFinancialSourceMap();
		try {
			int numBalances = this.getActivities().get(0).getActivityEconomicAccounts().get(0).getBalances().size();
			double[] array = new double[numBalances];
			for (Map.Entry<String, double[]> entry : map.entrySet()) {
				for (int i = 0; i < array.length; i++) {
					array[i] += entry.getValue()[i];
				}
			}
		return new DtoFinanceFooter(this.getName(), array);
		} catch (IndexOutOfBoundsException ex) {}
		return null;
	} 
	
	// generateProgrammeFinancialSourceMap
	public Map<String, double[]> generateProgrammeFinancialSourceMap() {
		Map<String, double[]> map = new HashMap<>();
		if (!this.getActivities().isEmpty()) {
			List<Activity> activities = this.getActivities();
			for (Activity activity : activities) {
				Map<String, double[]> activityMap = activity.generateActivityFinancialSourceMap();
				for (Map.Entry<String, double[]> entry : activityMap.entrySet()) {
					if (map.containsKey(entry.getKey())) {
						double[] array1 = map.get(entry.getKey());
						double[] array2 = entry.getValue();
						for (int i = 0; i < array1.length; i++) {
							array1[i] += array2[i];
						}
						map.put(entry.getKey(), array1);
					} else {
						map.put(entry.getKey(), entry.getValue());
					}
				}
			}
		}
		if (!this.getProjects().isEmpty()) {
			List<Project> projects = this.getProjects();
			for (Project project : projects) {
				Map<String, double[]> projectMap = project.generateProjectFinancialSourceMap();
				for (Map.Entry<String, double[]> entry : projectMap.entrySet()) {
					if (map.containsKey(entry.getKey())) {
						double[] array1 = map.get(entry.getKey());
						double[] array2 = entry.getValue();
						for (int i = 0; i < array1.length; i++) {
							array1[i] += array2[i];
						}
						map.put(entry.getKey(), array1);
					} else {
						map.put(entry.getKey(), entry.getValue());
					}
				}
			}
		}
		return map;
 	}
	
// // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
	
	// C H A R T 
	
	public DtoProgrammeChartObject generateProgrammeChart() {
		DtoProgrammeChartObject dtoProgrammeChartObject = new DtoProgrammeChartObject();
		dtoProgrammeChartObject.setName(name);
		dtoProgrammeChartObject.setValue(this.generateProgrammeValue());
		return dtoProgrammeChartObject;
	}
	
	public double generateProgrammeValue() {
		DtoFinanceFooter dtoFinanceFooter = this.generateProgrammeFinancialSourceFooter();
		if (dtoFinanceFooter != null) {
			return dtoFinanceFooter.getAmounts()[dtoFinanceFooter.getAmounts().length-6];
		}
		return 0;
	}
	
}

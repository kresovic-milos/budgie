package com.attozoic.main.model;

import java.util.ArrayList;
import java.util.Collections;
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

import com.attozoic.main.model.dto.DtoProgrammeEconomicAccount;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
	//@JsonIgnoreProperties({"categoryID", "programmes"}) 
	@JsonIdentityReference(alwaysAsId = true)
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
	
	// List of ProgrammeEconomicAccounts 
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
					if (superEconomicAccount2.getActiveState() == ActiveState.ACTIVE) {
						ActivityEconomicAccount aea = (ActivityEconomicAccount)superEconomicAccount2;
						activityEconomicAccount = activityEconomicAccount.sumActivityEconomicAccounts(aea);
					}
				}
				DtoProgrammeEconomicAccount programmeEconomicAccount = new DtoProgrammeEconomicAccount(entry.getKey(), activityEconomicAccount.getCode(), activityEconomicAccount.getBalances());
				programmeEconomicAccount.generateSumExpences123();
				programmeEconomicAccounts.add(programmeEconomicAccount);
			} else {
				superEconomicAccount = new ProjectEconomicAccount();
				ProjectEconomicAccount projectEconomicAccount = (ProjectEconomicAccount)superEconomicAccount;
				projectEconomicAccount.generateBalances(numRebalances);
				for (SuperEconomicAccount superEconomicAccount2 : entry.getValue()) {
					if (superEconomicAccount2.getActiveState() == ActiveState.ACTIVE) {
						ProjectEconomicAccount pea = (ProjectEconomicAccount)superEconomicAccount2;
						projectEconomicAccount = projectEconomicAccount.sumProjectEconomicAccounts(pea);
					}
				}
				DtoProgrammeEconomicAccount programmeEconomicAccount = new DtoProgrammeEconomicAccount(entry.getKey(), projectEconomicAccount.getCode(), projectEconomicAccount.getBalances());
				programmeEconomicAccount.generateSumExpences123();
				programmeEconomicAccounts.add(programmeEconomicAccount);
			}
		}
		Collections.sort(programmeEconomicAccounts);
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
	
}

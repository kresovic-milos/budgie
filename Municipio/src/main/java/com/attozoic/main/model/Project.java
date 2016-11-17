package com.attozoic.main.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.attozoic.main.model.dto.DtoProjectEconomicAccount;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="projects")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=Project.class)
public class Project extends SuperEntity {

	private String code;
	private String name;

    private String purpose;
	private String rudiment;
	private String description;
	private String anex;
	private String responsibleAuthority;
	
	// Function
	Long categoryFunctionID;
	String functionCode;
	String function;
	// Head
	Long categoryHeadID;
	String headCode;
	String head;
	// Authority
	Long categoryAuthorityID;
	String authorityCode;
	String authority;
	String authorityJbbk;

    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="programme_uid")
    @NotFound(action=NotFoundAction.IGNORE)
    @JsonIgnoreProperties({"categoryID", "code", "ordNumber", "name", "purpose", "rudiment", "description", "budgetUser", "responsibleAuthority", "programmeGoals", "activities", "projects"})
    private Programme programme;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="project")
    private List<ProjectGoal> projectGoals = new ArrayList<>();
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="project")
    private List<ProjectEconomicAccount> projectEconomicAccounts = new ArrayList<>();
	
	public Project() {}
    
// // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //

	// ProjectEconomicAccount LIST and FOOTER
	
	// FOOTER of List of GROUPS
	public SuperEconomicAccount generateProjectEconomicAccountFooter(int numRebalances) {
		ProjectEconomicAccount projectEconomicAccount = new ProjectEconomicAccount();
		projectEconomicAccount.generateBalances(numRebalances);
		for (ProjectEconomicAccount projectEconomicAccount2 : this.projectEconomicAccounts) {
			projectEconomicAccount.sumProjectEconomicAccounts(projectEconomicAccount2);
		}
		projectEconomicAccount.generateSumExpences123();
		projectEconomicAccount.setName(this.getName());
		projectEconomicAccount.setCategoryName(this.getName());
		return projectEconomicAccount;
	}
	
	// List of GROUPS (ThreeDigits ProjectEconomicAccount i svi njegovi SixDigits)
	public List<DtoProjectEconomicAccount> generateProjectEconomicAccountDTOsList(int numRebalances) {
		Map<String, List<ProjectEconomicAccount>> map = generateThreeDigitsProjectEconomicAccountsMap();
		List<DtoProjectEconomicAccount> projectEconomicAccounts = new ArrayList<>();
		for (Map.Entry<String, List<ProjectEconomicAccount>> entry : map.entrySet()) {
			ProjectEconomicAccount projectEconomicAccount = new ProjectEconomicAccount();
			projectEconomicAccount.generateBalances(numRebalances);
			for (ProjectEconomicAccount projectEconomicAccount2 : entry.getValue()) {
				projectEconomicAccount.sumProjectEconomicAccounts(projectEconomicAccount2);
			}
			projectEconomicAccount.setCode(entry.getKey());
			projectEconomicAccounts.add(new DtoProjectEconomicAccount(projectEconomicAccount, entry.getValue()));
		}
		return projectEconomicAccounts;
	}
	
	private Map<String, List<ProjectEconomicAccount>> generateThreeDigitsProjectEconomicAccountsMap() {
		Map<String, List<ProjectEconomicAccount>> map = new HashMap<>();
		for (ProjectEconomicAccount projectEconomicAccount : this.projectEconomicAccounts) {
			String threeDigits = projectEconomicAccount.getCode().substring(0, 3).concat("000");
			if (map.containsKey(threeDigits)) {
				List<ProjectEconomicAccount> projectEconomicAccounts = map.get(threeDigits);
				projectEconomicAccounts.add(projectEconomicAccount);
				map.put(threeDigits, projectEconomicAccounts);
			} else {
				List<ProjectEconomicAccount> projectEconomicAccounts = new ArrayList<>();
				projectEconomicAccounts.add(projectEconomicAccount);
				map.put(threeDigits, projectEconomicAccounts);
			}
		}
		return map;
	}
	
// // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
	
	
//	public List<DtoProjectEconomicAccount> generateProjectEconomicAccountDTOsList(int numRebalances) {
//		Map<String, List<ProjectEconomicAccount>> map = generateThreeDigitsProjectEconomicAccountsMap();
//		List<DtoProjectEconomicAccount> projectEconomicAccounts = new ArrayList<>();
//		for (Map.Entry<String, List<ProjectEconomicAccount>> entry : map.entrySet()) {
//			ProjectEconomicAccount projectEconomicAccount = new ProjectEconomicAccount();
//			projectEconomicAccount.generateBalances(numRebalances);
//			List<ProjectEconomicAccount> list = entry.getValue();
//			for (ProjectEconomicAccount projectEconomicAccount2 : list) {
//				projectEconomicAccount.sumProjectEconomicAccounts(projectEconomicAccount2);
//			}
//			projectEconomicAccount.setCode(entry.getKey());
//			projectEconomicAccounts.add(new DtoProjectEconomicAccount(projectEconomicAccount, entry.getValue()));
//		}
//		return projectEconomicAccounts;
//	}
//
//	public Map<String, List<ProjectEconomicAccount>> generateThreeDigitsProjectEconomicAccountsMap() {
//		Map<String, List<ProjectEconomicAccount>> map = new HashMap<>();
//		for (ProjectEconomicAccount projectEconomicAccount : projectEconomicAccounts) {
//			String threeDigits = projectEconomicAccount.getCode().substring(0, 3).concat("000");
//			if (map.containsKey(threeDigits)) {
//				List<ProjectEconomicAccount> projectEconomicAccounts = map.get(threeDigits);
//				projectEconomicAccounts.add(projectEconomicAccount);
//				map.put(threeDigits, projectEconomicAccounts);
//			} else {
//				List<ProjectEconomicAccount> projectEconomicAccounts = new ArrayList<>();
//				projectEconomicAccounts.add(projectEconomicAccount);
//				map.put(threeDigits, projectEconomicAccounts);
//			}
//		}
//		return map;
//	}
	
}

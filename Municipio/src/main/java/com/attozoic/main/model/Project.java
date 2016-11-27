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

import com.attozoic.main.model.balance.Balance;
import com.attozoic.main.model.dto.DtoBalanceFinancialSourceObject;
import com.attozoic.main.model.dto.DtoFinanceFooter;
import com.attozoic.main.model.dto.DtoFinancialSource;
import com.attozoic.main.model.dto.DtoProjectEconomicAccount;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
	@Column(length = 512)
	private String name;

	@Column(length = 2048)
    private String purpose;
	@Column(length = 2048)
	private String rudiment;
	@Column(length = 2048)
	private String description;
	@Column(length = 2048)
	private String anex;
	@Column(length = 2048)
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
	// Book
	Long categoryBookID;
	String bookCode;
	String book;
	
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="programme_uid")
    @NotFound(action=NotFoundAction.IGNORE)
    @JsonIgnoreProperties({"categoryID", "code", "ordNumber", "name", "purpose", "rudiment", "description", "budgetUser", "responsibleAuthority", "programmeGoals", "activities", "projects"})
    private Programme programme;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="project")
	@JsonIgnore
    private List<ProjectGoal> projectGoals = new ArrayList<>();
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="project")
	@JsonIgnore
    private List<ProjectEconomicAccount> projectEconomicAccounts = new ArrayList<>();
	
	public Project() {}
    
// // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //

	// ProjectEconomicAccount LIST and FOOTER
	
	// FOOTER of List of GROUPS
	public SuperEconomicAccount generateProjectEconomicAccountFooter(int numRebalances) {
		ProjectEconomicAccount projectEconomicAccount = new ProjectEconomicAccount();
		projectEconomicAccount.generateBalances(numRebalances);
		for (ProjectEconomicAccount projectEconomicAccount2 : this.projectEconomicAccounts) {
			List<Balance> balances = projectEconomicAccount2.getBalances();
			Collections.sort(balances);
			projectEconomicAccount2.setBalances(balances);
			if (projectEconomicAccount2.getActiveState()==ActiveState.ACTIVE) {
				projectEconomicAccount = projectEconomicAccount.sumProjectEconomicAccounts(projectEconomicAccount2);
			}
		}
		projectEconomicAccount.generateSumExpences123();
		projectEconomicAccount.setName(this.getName());
		projectEconomicAccount.setCategoryName(this.getName());
		return projectEconomicAccount;
	}
	
	// List of GROUPS (ThreeDigits ProjectEconomicAccount i svi njegovi SixDigits)
	public List<DtoProjectEconomicAccount> generateProjectEconomicAccountsList(int numRebalances) {
		Map<String, List<ProjectEconomicAccount>> map = generateThreeDigitsProjectEconomicAccountsMap();
		List<DtoProjectEconomicAccount> projectEconomicAccounts = new ArrayList<>();
		for (Map.Entry<String, List<ProjectEconomicAccount>> entry : map.entrySet()) {
			ProjectEconomicAccount projectEconomicAccount = new ProjectEconomicAccount();
			projectEconomicAccount.generateBalances(numRebalances);
			for (ProjectEconomicAccount projectEconomicAccount2 : entry.getValue()) {
				projectEconomicAccount = projectEconomicAccount.sumProjectEconomicAccounts(projectEconomicAccount2);
			}
			projectEconomicAccount.setCode(entry.getKey());
			Collections.sort(entry.getValue());
			projectEconomicAccounts.add(new DtoProjectEconomicAccount(projectEconomicAccount, entry.getValue()));
		}
		Collections.sort(projectEconomicAccounts);
		return projectEconomicAccounts;
	}
	
	private Map<String, List<ProjectEconomicAccount>> generateThreeDigitsProjectEconomicAccountsMap() {
		Map<String, List<ProjectEconomicAccount>> map = new HashMap<>();
		for (ProjectEconomicAccount projectEconomicAccount : this.projectEconomicAccounts) {
			List<Balance> balances = projectEconomicAccount.getBalances();
			Collections.sort(balances);
			projectEconomicAccount.setBalances(balances);
			if (projectEconomicAccount.getActiveState()==ActiveState.ACTIVE) {
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
		}
		return map;
	}
	
	// // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
	
	// ProjectFinancialSource LIST and FOOTER
	
	// generateProjectFinancialSourceMap
	public DtoFinanceFooter generateProjectFinancialSourceFooter() {
		Map<String, double[]> map = this.generateProjectFinancialSourceMap();
		int numBalances = this.getProjectEconomicAccounts().get(0).getBalances().size();
		double[] array = new double[numBalances];
		for (Map.Entry<String, double[]> entry : map.entrySet()) {
			for (int i = 0; i < array.length; i++) {
				array[i] += entry.getValue()[i];
			}
		}
		return new DtoFinanceFooter(this.getName(), array);
	}
	
	// generateProjectFinancialSourceMap
	public Map<String, double[]> generateProjectFinancialSourceMap() {
		Map<String, double[]> map = new HashMap<>();
		try {
			List<DtoBalanceFinancialSourceObject> list = this.getProjectEconomicAccounts().get(0).generateProjectEconomicAccountDtoBalanceFinancialSourceObjectLists();
			for (int i = 1; i < this.projectEconomicAccounts.size(); i++) {
				if (projectEconomicAccounts.get(i).getActiveState()==ActiveState.ACTIVE) {
					list = this.projectEconomicAccounts.get(i).mergeProjectFinancialSourceBalancesLists(list, this.projectEconomicAccounts.get(i).generateProjectEconomicAccountDtoBalanceFinancialSourceObjectLists());
				}
			}		
			int numBalances = this.getProjectEconomicAccounts().get(0).getBalances().size();
			for (int i = 0; i < list.size(); i++) {
				List<DtoFinancialSource> dtoFinancialSources = list.get(i).getDtoFinancialSources();
				for (DtoFinancialSource dtoFinancialSource : dtoFinancialSources) {
					if (map.containsKey(dtoFinancialSource.getName())) {
						double[] dtoFinancialSourceArray = map.get(dtoFinancialSource.getName());
						dtoFinancialSourceArray[i] = dtoFinancialSource.getAmount();
						map.put(dtoFinancialSource.getName(), dtoFinancialSourceArray);
					} else {
						double[] dtoFinancialSourceArray = new double[numBalances];
						for (int j = 0; j < numBalances; j++) {
							dtoFinancialSourceArray[i] = 0.0;
						}
						dtoFinancialSourceArray[i] = dtoFinancialSource.getAmount();
						map.put(dtoFinancialSource.getName(), dtoFinancialSourceArray);
					}
				}
			}
		} catch(IndexOutOfBoundsException ex) {}
		return map;
	}
	
}

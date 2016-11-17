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

import com.attozoic.main.model.dto.DtoActivityEconomicAccount;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="activities")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=Activity.class)
public class Activity extends SuperEntity { 
	
	private Long categoryID;
	
	private String ordNumber; 
	private String categoryName;
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
	// Book
	Long categoryBookID;
	String bookCode;
	String book;
    
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="programme_uid")
    @NotFound(action=NotFoundAction.IGNORE)
    @JsonIgnoreProperties({"categoryID", "code", "ordNumber", "name", "purpose", "rudiment", "description", "budgetUser", "responsibleAuthority", "programmeGoals", "activities", "projects"})
    private Programme programme;

    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="activity")
    private List<ActivityGoal> activityGoals = new ArrayList<>();
    
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="activity")
    private List<ActivityEconomicAccount> activityEconomicAccounts = new ArrayList<>();
    
	public Activity() {}
	
// // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
	
	// ActivityEconomicAccount LIST and FOOTER
	
	// FOOTER of List of GROUPS
	public SuperEconomicAccount generateActivityEconomicAccountFooter(int numRebalances) {
		ActivityEconomicAccount activityEconomicAccount = new ActivityEconomicAccount();
		activityEconomicAccount.generateBalances(numRebalances);
		for (ActivityEconomicAccount activityEconomicAccount2 : this.activityEconomicAccounts) {
			activityEconomicAccount = activityEconomicAccount.sumActivityEconomicAccounts(activityEconomicAccount2);
		}
		activityEconomicAccount.generateSumExpences123();
		activityEconomicAccount.setName(this.getName());
		activityEconomicAccount.setCategoryName(this.getCategoryName());
		return activityEconomicAccount;
	}
	
	// List of GROUPS (ThreeDigits ActivityEconomicAccount i svi njegovi SixDigits)
	public List<DtoActivityEconomicAccount> generateActivityEconomicAccountDTOsList(int numRebalances) {
		Map<String, List<ActivityEconomicAccount>> map = generateThreeDigitsActivityEconomicAccountsMap();
		List<DtoActivityEconomicAccount> activityEconomicAccounts = new ArrayList<>();
		for (Map.Entry<String, List<ActivityEconomicAccount>> entry : map.entrySet()) {
			ActivityEconomicAccount activityEconomicAccount = new ActivityEconomicAccount();
			activityEconomicAccount.generateBalances(numRebalances);
			for (ActivityEconomicAccount activityEconomicAccount2 : entry.getValue()) {
				activityEconomicAccount = activityEconomicAccount.sumActivityEconomicAccounts(activityEconomicAccount2);
			}
			activityEconomicAccount.setCode(entry.getKey());
			activityEconomicAccounts.add(new DtoActivityEconomicAccount(activityEconomicAccount, entry.getValue()));
		}
		return activityEconomicAccounts;
	}
	
	private Map<String, List<ActivityEconomicAccount>> generateThreeDigitsActivityEconomicAccountsMap() {
		Map<String, List<ActivityEconomicAccount>> map = new HashMap<>();
		for (ActivityEconomicAccount activityEconomicAccount : this.activityEconomicAccounts) {
			String threeDigits = activityEconomicAccount.getCode().substring(0, 3).concat("000");
			if (map.containsKey(threeDigits)) {
				List<ActivityEconomicAccount> activityEconomicAccounts = map.get(threeDigits);
				activityEconomicAccounts.add(activityEconomicAccount);
				map.put(threeDigits, activityEconomicAccounts);
			} else {
				List<ActivityEconomicAccount> activityEconomicAccounts = new ArrayList<>();
				activityEconomicAccounts.add(activityEconomicAccount);
				map.put(threeDigits, activityEconomicAccounts);
			}
		}
		return map;
	}
	
// // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
	
	
	
	
	// Metode vezane za DTO objekte F I N A N C I A L   S O U R C E 
	
//	public void generateActivityFinancialSourceDTOsList() {
//		
//		List<DtoBalanceActivityFinancialSourceListObject> list = this.generateActivityFinancialSourceDTO();
//		int numBAlances = list.size();
//		
//		Map<String, List<Double>> map = new HashMap<>();
//		
//		List<ActivityFinancialSource> l = new ArrayList<>(); // Bukvalno SVI FinSrc-ovi u jednoj listi
//		for (DtoBalanceActivityFinancialSourceListObject dto : list) {
//			for (ActivityFinancialSource activityFinancialSource : dto.getActivityFinancialSources()) {
//				l.add(activityFinancialSource);
//			}
//		}
//		
//		
//		
//		
//		
//		
//	}
//	
//	public List<DtoBalanceActivityFinancialSourceListObject> generateActivityFinancialSourceDTO() {
//		List<DtoBalanceActivityFinancialSourceListObject> list = this.activityEconomicAccounts.get(0).generateActivityEconomicAccountFinancialSourceLists();
//		for (int i = 1; i < this.activityEconomicAccounts.size(); i++) {
//			list = merge(list, this.activityEconomicAccounts.get(i).generateActivityEconomicAccountFinancialSourceLists());	
//		}
//		return list;
//	}
//	
//	private List<DtoBalanceActivityFinancialSourceListObject> merge(List<DtoBalanceActivityFinancialSourceListObject> list1, List<DtoBalanceActivityFinancialSourceListObject> list2) {
//		List<DtoBalanceActivityFinancialSourceListObject> list = new ArrayList<>();
//		for (int i = 0; i < list1.size(); i++) {
//			list.add(list1.get(i).sumDtoBalanceActivityFinancialSourceListObjects(list2.get(i)));
//		}
//		return list;
//	}
//	
//// // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
//	
//	// Metode vezane za DTO objekte EconomicAccounta
//	
//	public ActivityEconomicAccount generateActivityEconomicAccountFooter(int numRebalances) {
//		ActivityEconomicAccount activityEconomicAccount = new ActivityEconomicAccount();
//		activityEconomicAccount.generateBalances(numRebalances);
//		for (ActivityEconomicAccount activityEconomicAccount2 : this.activityEconomicAccounts) {
//			activityEconomicAccount.sumActivityEconomicAccounts(activityEconomicAccount2);
//		}
//		activityEconomicAccount.setName(this.getName());
//		return activityEconomicAccount;
//	}
//	
//	public List<DtoActivityEconomicAccount> generateActivityEconomicAccountDTOsList(int numRebalances) {
//		Map<String, List<ActivityEconomicAccount>> map = generateThreeDigitsActivityEconomicAccountsMap();
//		List<DtoActivityEconomicAccount> activityEconomicAccounts = new ArrayList<>();
//		for (Map.Entry<String, List<ActivityEconomicAccount>> entry : map.entrySet()) {
//			ActivityEconomicAccount activityEconomicAccount = new ActivityEconomicAccount();
//			activityEconomicAccount.generateBalances(numRebalances);
//			for (ActivityEconomicAccount activityEconomicAccount2 : entry.getValue()) {
//				activityEconomicAccount.sumActivityEconomicAccounts(activityEconomicAccount2);
//			}
//			activityEconomicAccount.setCode(entry.getKey());
//			activityEconomicAccounts.add(new DtoActivityEconomicAccount(activityEconomicAccount, entry.getValue()));
//			System.out.println(activityEconomicAccount.getBalances());
//		}
//		return activityEconomicAccounts;
//	}
//
//	private Map<String, List<ActivityEconomicAccount>> generateThreeDigitsActivityEconomicAccountsMap() {
//		Map<String, List<ActivityEconomicAccount>> map = new HashMap<>();
//		for (ActivityEconomicAccount activityEconomicAccount : activityEconomicAccounts) {
//			String threeDigits = activityEconomicAccount.getCode().substring(0, 3).concat("000");
//			if (map.containsKey(threeDigits)) {
//				List<ActivityEconomicAccount> activityEconomicAccounts = map.get(threeDigits);
//				activityEconomicAccounts.add(activityEconomicAccount);
//				map.put(threeDigits, activityEconomicAccounts);
//			} else {
//				List<ActivityEconomicAccount> activityEconomicAccounts = new ArrayList<>();
//				activityEconomicAccounts.add(activityEconomicAccount);
//				map.put(threeDigits, activityEconomicAccounts);
//			}
//		}
//		return map;
//	}
	
// // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
	
	
	
}

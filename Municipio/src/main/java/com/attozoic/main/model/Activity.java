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
import com.attozoic.main.model.dto.DtoActivityEconomicAccount;
import com.attozoic.main.model.dto.DtoBalanceFinancialSourceObject;
import com.attozoic.main.model.dto.DtoFinancialSource;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="activity")
    @JsonIgnore
    private List<ActivityGoal> activityGoals = new ArrayList<>();
    
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="activity")
    @JsonIgnore
    private List<ActivityEconomicAccount> activityEconomicAccounts = new ArrayList<>();
    
	public Activity() {}
	
// // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
	
	// ActivityEconomicAccount LIST and FOOTER
	
	// FOOTER of List of GROUPS
	public SuperEconomicAccount generateActivityEconomicAccountFooter(int numRebalances) {
		ActivityEconomicAccount activityEconomicAccount = new ActivityEconomicAccount();
		activityEconomicAccount.generateBalances(numRebalances);
		for (ActivityEconomicAccount activityEconomicAccount2 : this.activityEconomicAccounts) {
			List<Balance> balances = activityEconomicAccount2.getBalances();
			Collections.sort(balances);
			activityEconomicAccount2.setBalances(balances);
			if (activityEconomicAccount2.getActiveState()==ActiveState.ACTIVE) {
				activityEconomicAccount = activityEconomicAccount.sumActivityEconomicAccounts(activityEconomicAccount2);
			}
		}
		activityEconomicAccount.generateSumExpences123();
		activityEconomicAccount.setName(this.getName());
		activityEconomicAccount.setCategoryName(this.getCategoryName());
		return activityEconomicAccount;
	}
	
	// List of GROUPS (ThreeDigits ActivityEconomicAccount i svi njegovi SixDigits)
	public List<DtoActivityEconomicAccount> generateActivityEconomicAccountsList(int numRebalances) {
		Map<String, List<ActivityEconomicAccount>> map = generateThreeDigitsActivityEconomicAccountsMap();
		List<DtoActivityEconomicAccount> activityEconomicAccounts = new ArrayList<>();
		for (Map.Entry<String, List<ActivityEconomicAccount>> entry : map.entrySet()) {
			ActivityEconomicAccount activityEconomicAccount = new ActivityEconomicAccount();
			activityEconomicAccount.generateBalances(numRebalances);
			for (ActivityEconomicAccount activityEconomicAccount2 : entry.getValue()) {
				activityEconomicAccount = activityEconomicAccount.sumActivityEconomicAccounts(activityEconomicAccount2);
			}
			activityEconomicAccount.setCode(entry.getKey());
			Collections.sort(entry.getValue());
			activityEconomicAccounts.add(new DtoActivityEconomicAccount(activityEconomicAccount, entry.getValue()));
		}
		Collections.sort(activityEconomicAccounts);
		return activityEconomicAccounts;
	}
	
	private Map<String, List<ActivityEconomicAccount>> generateThreeDigitsActivityEconomicAccountsMap() {
		Map<String, List<ActivityEconomicAccount>> map = new HashMap<>();
		for (ActivityEconomicAccount activityEconomicAccount : this.activityEconomicAccounts) {
			List<Balance> balances = activityEconomicAccount.getBalances();
			Collections.sort(balances);
			activityEconomicAccount.setBalances(balances);
			if (activityEconomicAccount.getActiveState()==ActiveState.ACTIVE) {
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
		}
		return map;
	}
	
// // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
	
	// ActivityFinancialSource LIST and FOOTER
	
	// generateActivityFinancialSourceFooter
//	public DtoFinanceFooter generateActivityFinancialSourceFooter() {
//		Map<String, double[]> map = this.generateActivityFinancialSourceMap();
//		int numBalances = this.getActivityEconomicAccounts().get(0).getBalances().size();
//		double[] array = new double[numBalances];
//		try {
//			for (Map.Entry<String, double[]> entry : map.entrySet()) {
//				for (int i = 0; i < array.length; i++) {
//					array[i] += entry.getValue()[i];
//				}
//			}
//		} catch(IndexOutOfBoundsException ex) {}
//		return new DtoFinanceFooter(this.getName(), array);
//	}
	
	// generateActivityFinancialSourceMap
	public Map<String, double[]> generateActivityFinancialSourceMap() {
		Map<String, double[]> map = new HashMap<>();
		
		try { // D I L E M A ! ! ! - ako prvi nije ACTIVE!!!
			
			List<DtoBalanceFinancialSourceObject> list = this.getActivityEconomicAccounts().get(0).generateActivityEconomicAccountDtoBalanceFinancialSourceObjectLists();
			Collections.sort(list);
			for (int i = 1; i < this.activityEconomicAccounts.size(); i++) {
				if (activityEconomicAccounts.get(i).getActiveState()==ActiveState.ACTIVE) {
					//Collections.sort(this.activityEconomicAccounts.get(i).generateActivityEconomicAccountDtoBalanceFinancialSourceObjectLists());
					list = this.activityEconomicAccounts.get(i).mergeActivityFinancialSourceBalancesLists(list, this.activityEconomicAccounts.get(i).generateActivityEconomicAccountDtoBalanceFinancialSourceObjectLists());
				}
			}		
			int numBalances = this.getActivityEconomicAccounts().get(0).getBalances().size();
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
			
		} catch(IndexOutOfBoundsException ex){} 
		return map;
	}
	
}

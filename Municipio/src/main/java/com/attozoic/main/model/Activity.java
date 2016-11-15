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

import com.attozoic.main.model.dto.DtoActivityEconomicAccountThreeDigitsCollection;
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
	
	private String code; 
	private String ordNumber; 
	private String categoryName;
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

    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="activity")
    private List<ActivityGoal> activityGoals = new ArrayList<>();
    
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="activity")
    private List<ActivityEconomicAccount> activityEconomicAccounts = new ArrayList<>();
    
	public Activity() {}
	
	public List<DtoActivityEconomicAccountThreeDigitsCollection> generateThreeDigitsActivityEconomicAccountsDTOList(int numRebalances) {
		Map<String, List<ActivityEconomicAccount>> map = generateThreeDigitsActivityEconomicAccountsMap();
		List<DtoActivityEconomicAccountThreeDigitsCollection> activityEconomicAccounts = new ArrayList<>();
		for (Map.Entry<String, List<ActivityEconomicAccount>> entry : map.entrySet()) {
			ActivityEconomicAccount activityEconomicAccount = new ActivityEconomicAccount();
			activityEconomicAccount.generateBalances(numRebalances);
			List<ActivityEconomicAccount> list = entry.getValue();
			for (ActivityEconomicAccount activityEconomicAccount2 : list) {
				activityEconomicAccount.sumActivityEconomicAccounts(activityEconomicAccount2);
			}
			activityEconomicAccount.setCode(entry.getKey());
			activityEconomicAccounts.add(new DtoActivityEconomicAccountThreeDigitsCollection(activityEconomicAccount, entry.getValue()));
		}
		return activityEconomicAccounts;
	}

	public Map<String, List<ActivityEconomicAccount>> generateThreeDigitsActivityEconomicAccountsMap() {
		Map<String, List<ActivityEconomicAccount>> map = new HashMap<>();
		for (ActivityEconomicAccount activityEconomicAccount : activityEconomicAccounts) {
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
	
//	public Map<String, ActivityEconomicAccount> generateThreeDigitsActivityEconomicAccountsMap() {
//		Map<String, ActivityEconomicAccount> map = new HashMap<>();
//		for (ActivityEconomicAccount activityEconomicAccount : activityEconomicAccounts) {
//			String threeDigits = activityEconomicAccount.getCode().substring(0, 3).concat("000");
//			if (map.containsKey(threeDigits)) {
//				map.put(threeDigits, map.get(threeDigits).sumActivityEconomicAccounts(activityEconomicAccount));
//			} else {
//				map.put(threeDigits, activityEconomicAccount);
//			}
//		}
//		return map;
//	}
	
}

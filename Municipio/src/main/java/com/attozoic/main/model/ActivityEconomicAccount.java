package com.attozoic.main.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.attozoic.main.model.balance.Balance;
import com.attozoic.main.model.balance.BalanceType;
import com.attozoic.main.model.dto.DtoBalanceFinancialSourceObject;
import com.attozoic.main.model.dto.DtoFinancialSource;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="activity_economic_accounts")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=ActivityEconomicAccount.class)
@JsonTypeName("ativityEconomicAcount")
public class ActivityEconomicAccount extends SuperEconomicAccount implements Comparable<ActivityEconomicAccount> {

	private String type;
	
	private Long categoryID;
	
	private String code;
	private String name;
	private String poz;

	private double sumExpenses123Budget = 0;
	private double sumExpenses123Others = 0;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="activity_uid")
    @NotFound(action=NotFoundAction.IGNORE)
	@JsonIgnoreProperties({"categoryID", "code", "ordNumber", "categoryName", "name", "purpose", "rudiment", "description", "anex", "responsibleAuthority", "categoryFunctionID", "functionCode", "function", "categoryHeadID", "headCode", "head", "categoryAuthorityID", "authorityCode", "authority", "authorityJbbk", "categoryBookID", "bookCode", "book", "programme", "activityGoals", "activityEconomicAccounts"})
    private Activity activity;
	
	public ActivityEconomicAccount() {
		this.type = "activityEconomicAccount";
	}
	
	public void generateBalances(int numRebalances) {
		this.balances.add(new Balance(BalanceType.BUDGET, 2016, this));
		this.balances.add(new Balance(BalanceType.OTHERS, 2016, this));
		this.balances.add(new Balance(BalanceType.BUDGET, 2017, this));
		this.balances.add(new Balance(BalanceType.OTHERS, 2017, this));
		if (numRebalances > 0) {
			for (int i = 0; i < numRebalances; i++) {
				this.balances.add(new Balance(BalanceType.BUDGET, 2017 + (i + 1) * 0.1, this));
				this.balances.add(new Balance(BalanceType.OTHERS, 2017 + (i + 1) * 0.1, this));
			}
		}
		this.balances.add(new Balance(BalanceType.BUDGET, 2018, this));
		this.balances.add(new Balance(BalanceType.OTHERS, 2018, this));
		this.balances.add(new Balance(BalanceType.BUDGET, 2019, this));
		this.balances.add(new Balance(BalanceType.OTHERS, 2019, this));
	}
	
    public void addRebalance(int numRebalances) {
    	this.balances.add(this.balances.size()-4, new Balance(BalanceType.BUDGET, 2017 + (numRebalances + 1) * 0.1, this));
    	this.balances.add(this.balances.size()-4, new Balance(BalanceType.OTHERS, 2017 + (numRebalances + 1) * 0.1, this));
    }
    
    public void removeRebalance(int numRebalances) {
    	this.balances.remove(numRebalances-5);
    	this.balances.remove(numRebalances-5);
    }
	
    public void generateSumExpences123() {
    	this.setSumExpenses123Budget(0);
    	this.setSumExpenses123Others(0);
    	
    	for (Balance balance : balances) {
			if (balance.getYear() != 2016) {
	    		if (balance.getBalanceType() == BalanceType.BUDGET) {
	    			this.setSumExpenses123Budget(this.getSumExpenses123Budget() + balance.getBalance_amount());
	    		} else {
	    			this.setSumExpenses123Others(this.getSumExpenses123Others() + balance.getBalance_amount());
	    		}
			}
		} 
    	
//		for (int i = 2; i < this.balances.size(); i++) {
//    		if (this.balances.get(i).getBalanceType() == BalanceType.BUDGET) {
//    			this.setSumExpenses123Budget(this.getSumExpenses123Budget() + this.balances.get(i).getBalance_amount());
//    		} else {
//    			this.setSumExpenses123Others(this.getSumExpenses123Others() + this.balances.get(i).getBalance_amount());
//    		}
//    	}
    }
    
 // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
    
    public ActivityEconomicAccount sumActivityEconomicAccounts(ActivityEconomicAccount activityEconomicAccount) {
    	ActivityEconomicAccount activityEconomicAccount2 = new ActivityEconomicAccount();
    	activityEconomicAccount2.setCode(this.getCode());
    	List<Balance> list1 = this.getBalances();
    	Collections.sort(list1);
    	this.setBalances(list1);
    	
    	List<Balance> list2 = activityEconomicAccount.getBalances();
    	Collections.sort(list2);
    	activityEconomicAccount.setBalances(list2);
    	
    	List<Balance> balances = new ArrayList<>();
    	for (int i = 0; i < this.balances.size(); i++) {
    		balances.add(this.balances.get(i).sumBalancesSameYearAndType(activityEconomicAccount.getBalances().get(i)));
    	}
    	Collections.sort(balances);
    	activityEconomicAccount2.setBalances(balances);
    	activityEconomicAccount2.generateSumExpences123();
    	return activityEconomicAccount2;
    }
    
// // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //    
    
    // mergeActivityFinancialSourceBalancesLists
    public List<DtoBalanceFinancialSourceObject> mergeActivityFinancialSourceBalancesLists(List<DtoBalanceFinancialSourceObject> list1, List<DtoBalanceFinancialSourceObject> list2) {
    	List<DtoBalanceFinancialSourceObject> list = new ArrayList<>();
    	for (int i = 0; i < this.balances.size(); i++) {
    		list.add(new DtoBalanceFinancialSourceObject(list1.get(i).getYear(), mergeDtoFinancialSourceLists(list1.get(i).getDtoFinancialSources(), list2.get(i).getDtoFinancialSources())));
    	}    	
    	return list;
    }
    
    // Vraca Listu Objekata sa godinom i listom FinSrcova za jedan EcAcc
    public List<DtoBalanceFinancialSourceObject> generateActivityEconomicAccountDtoBalanceFinancialSourceObjectLists() {
    	Collections.sort(balances);
    	List<DtoBalanceFinancialSourceObject> list = new ArrayList<>();
    	for (Balance balance : balances) {
			list.add(new DtoBalanceFinancialSourceObject(balance.getYear(), balance.generateDtoFinancialSourceList()));
		}
    	Collections.sort(list);
    	return list;
    }
    
    // Merge-uje BALANCE (Liste Finansijskih izvora tj DTO-ova)
    private List<DtoFinancialSource> mergeDtoFinancialSourceLists(List<DtoFinancialSource> list1, List<DtoFinancialSource> list2) {
    	List<DtoFinancialSource> list = new ArrayList<>();
    	Map<String, DtoFinancialSource> map = new HashMap<>();
    	for (DtoFinancialSource dtoFinancialSource : list1) {
			if (map.containsKey(dtoFinancialSource.getName())) {
				map.put(dtoFinancialSource.getName(), dtoFinancialSource.sumDtoFinancialSourcesReturnDTO(map.get(dtoFinancialSource.getName())));
			} else {
				map.put(dtoFinancialSource.getName(), dtoFinancialSource);
			}
		}
    	for (DtoFinancialSource dtoFinancialSource : list2) {
			if (map.containsKey(dtoFinancialSource.getName())) {
				map.put(dtoFinancialSource.getName(), dtoFinancialSource.sumDtoFinancialSourcesReturnDTO(map.get(dtoFinancialSource.getName())));
			} else {
				map.put(dtoFinancialSource.getName(), dtoFinancialSource);
			}
		}
    	for (Map.Entry<String, DtoFinancialSource> entry : map.entrySet()) {
			list.add(entry.getValue());
		}
    	return list;
    }

	@Override
	public int compareTo(ActivityEconomicAccount o) {
		return Integer.parseInt(this.getCode()) - Integer.parseInt(o.getCode());
	}
    
// // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //  
    
}

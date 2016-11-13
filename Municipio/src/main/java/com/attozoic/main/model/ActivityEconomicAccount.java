package com.attozoic.main.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.attozoic.main.model.balance.Balance;
import com.attozoic.main.model.balance.BalanceType;
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
public class ActivityEconomicAccount extends SuperEconomicAccount {
	
	private Long categoryID;

	private String code;
	private String categoryName;
	private String name;
	private String poz;

	private double sumExpenses123Budget;
	private double sumExpenses123Others;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="activity_uid")
    @NotFound(action=NotFoundAction.IGNORE)
	@JsonIgnoreProperties({"categoryID", "code", "ordNumber", "categoryName", "name", "purpose", "rudiment", "description", "anex", "responsibleAuthority", "categoryFunctionID", "functionCode", "function", "categoryHeadID", "headCode", "head", "categoryAuthorityID", "authorityCode", "authority", "authorityJbbk", "programme", "activityGoals", "activityEconomicAccounts"})
    private Activity activity;
	
	public ActivityEconomicAccount() {}
	
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
    	this.balances.add(this.balances.size()-4, new Balance(BalanceType.OTHERS, 2017 + (numRebalances + 1) * 0.1, this));
    	this.balances.add(this.balances.size()-4, new Balance(BalanceType.BUDGET, 2017 + (numRebalances + 1) * 0.1, this));
    }
    
    public void removeRebalance(int numRebalances) {
    	this.balances.remove(numRebalances-5);
    	this.balances.remove(numRebalances-5);
    }
	
//    public double sumExpenses123Budget() {
//    	double sum = 0;
//    	for (int i = 0; i < this.balanceContainers.size(); i+=2) {
//    		BalanceContainer balanceContainer = this.balanceContainers.get(i);
//    		for (int j = 0; j < balanceContainer.getBalances().size(); j++) {
//    			BalanceEconomicAccount bec = balanceContainer.getBalances().get(j);
//    			if (bec instanceof Balance) {
//    				sum += ((Balance) bec).getSumQuarters();
//    			} else if (bec instanceof BalanceNumeric) {
//    				sum += ((BalanceNumeric) bec).getValue();
//    			}
//    		}
//    	}
//    	return sum;
//    }
//    
//    public double sumExpenses123Others() {
//    	double sum = 0;
//    	for (int i = 1; i < this.balanceContainers.size(); i+=2) {
//    		BalanceContainer balanceContainer = this.balanceContainers.get(i);
//    		for (int j = 0; j < balanceContainer.getBalances().size(); j++) {
//    			BalanceEconomicAccount bec = balanceContainer.getBalances().get(j);
//    			if (bec instanceof Balance) {
//    				sum += ((Balance) bec).getSumQuarters();
//    			} else if (bec instanceof BalanceNumeric) {
//    				sum += ((BalanceNumeric) bec).getValue();
//    			}
//    		}
//    	}
//    	return sum;
//    }
//    
//    public void sumActivityEconomicAccounts(ActivityEconomicAccount activityEconomicAccount) {
//    	for (int i = 0; i < this.balanceContainers.size(); i++) {
//    		this.balanceContainers.get(i).sumBalanceContainers(activityEconomicAccount.getBalanceContainers().get(i));
//    	}
//    }
    
}

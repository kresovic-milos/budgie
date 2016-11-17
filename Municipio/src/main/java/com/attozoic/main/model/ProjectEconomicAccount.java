package com.attozoic.main.model;

import java.util.ArrayList;
import java.util.List;

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
@Table(name="project_economic_accounts")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=ProjectEconomicAccount.class)
@JsonTypeName("projectEconomicAccount")
public class ProjectEconomicAccount extends SuperEconomicAccount {
	
	
	private String type;
	
	private String code;
	private String name;
	private String poz;

	private double sumExpenses123Budget = 0;
	private double sumExpenses123Others = 0;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_uid")
    @NotFound(action=NotFoundAction.IGNORE)
	@JsonIgnoreProperties({"code", "name", "purpose", "rudiment", "description", "anex", "responsibleAuthority", "categoryFunctionID", "functionCode", "function", "categoryHeadID", "headCode", "head", "categoryAuthorityID", "authorityCode", "authority", "authorityJbbk", "programme", "projectGoals", "projectEconomicAccounts"})
    private Project project;
    
	public ProjectEconomicAccount() {
		this.type = "projectEconomicAccount";
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
    	this.balances.add(this.balances.size()-4, new Balance(BalanceType.OTHERS, 2017 + (numRebalances + 1) * 0.1, this));
    	this.balances.add(this.balances.size()-4, new Balance(BalanceType.BUDGET, 2017 + (numRebalances + 1) * 0.1, this));
    }
    
    public void removeRebalance(int numRebalances) {
    	this.balances.remove(numRebalances-5);
    	this.balances.remove(numRebalances-5);
    }
    
    public void generateSumExpences123() {
    	this.setSumExpenses123Budget(0);
    	this.setSumExpenses123Others(0);
		for (int i = 2; i < this.balances.size(); i++) {
    		if (this.balances.get(i).getBalanceType() == BalanceType.BUDGET) {
    			this.setSumExpenses123Budget(this.getSumExpenses123Budget() + this.balances.get(i).getBalance_amount());
    		} else {
    			this.setSumExpenses123Others(this.getSumExpenses123Others() + this.balances.get(i).getBalance_amount());
    		}
    	}
    }
    
    public ProjectEconomicAccount sumProjectEconomicAccounts(ProjectEconomicAccount projectEconomicAccount) {
    	ProjectEconomicAccount projectEconomicAccount2 = new ProjectEconomicAccount();
    	List<Balance> list = new ArrayList<>();
    	for (int i = 0; i < this.balances.size(); i++) {
    		list.add(this.balances.get(i).sumBalancesSameYearAndType(projectEconomicAccount.getBalances().get(i)));
    	}
    	projectEconomicAccount2.setBalances(list);
    	projectEconomicAccount2.generateSumExpences123();
    	return projectEconomicAccount2;
    }
    
//    public void sumProjectEconomicAccounts(ProjectEconomicAccount projectEconomicAccount) {
//    	this.setSumExpenses123Budget(this.getSumExpenses123Budget() + activityEconomicAccount.getSumExpenses123Budget());
//    	this.setSumExpenses123Others(this.getSumExpenses123Others() + activityEconomicAccount.getSumExpenses123Others());
//    	for (int i = 1; i < this.balances.size(); i++) {
//    		this.balances.get(i).sumActivityFinancialSourceBalances(activityEconomicAccount.getBalances().get(i));
//    	}
//    }
    
}

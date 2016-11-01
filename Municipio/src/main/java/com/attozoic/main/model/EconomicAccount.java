package com.attozoic.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="economic_accounts")
@Data
@EqualsAndHashCode(callSuper=true)
public class EconomicAccount extends SuperEntity {
	
	private Long categoryID;

	private String code;
	private String categoryName;
	private String name;
	private String poz;
	private String financialSrc;
	
	// 2016
	private long expenseBaseYearBudget1;
	private long expenseBaseYearBudget2;
	private long expenseBaseYearBudget3;
	private long expenseBaseYearBudget4;
	
	private long expenseBaseYearOthers1;
	private long expenseBaseYearOthers2;
	private long expenseBaseYearOthers3;
	private long expenseBaseYearOthers4;
	// 2017
	private long expenseBaseYearPlus1Budget1;
	private long expenseBaseYearPlus1Budget2;
	private long expenseBaseYearPlus1Budget3;
	private long expenseBaseYearPlus1Budget4;
	
	private long expenseBaseYearPlus1Others1;
	private long expenseBaseYearPlus1Others2;
	private long expenseBaseYearPlus1Others3;
	private long expenseBaseYearPlus1Others4;
	// 2018
	private long expenseBaseYearPlus2Budget1;
	private long expenseBaseYearPlus2Budget2;
	private long expenseBaseYearPlus2Budget3;
	private long expenseBaseYearPlus2Budget4;
	
	private long expenseBaseYearPlus2Others1;
	private long expenseBaseYearPlus2Others2;
	private long expenseBaseYearPlus2Others3;
	private long expenseBaseYearPlus2Others4;
	// 2019
	private long expenseBaseYearPlus3Budget1;
	private long expenseBaseYearPlus3Budget2;
	private long expenseBaseYearPlus3Budget3;
	private long expenseBaseYearPlus3Budget4;
	
	private long expenseBaseYearPlus3Others1;
	private long expenseBaseYearPlus3Others2;
	private long expenseBaseYearPlus3Others3;
	private long expenseBaseYearPlus3Others4;
	
	// Sum od Plus1 do Plus3
	private long sumExpenses123Budget;
	private long sumExpenses123Others;
	
	@ElementCollection
	@CollectionTable(name = "economicAccount_rebalances", joinColumns = @JoinColumn(name = "rebalance_uid"))
	private List<RebalanceTwoFields> rebalances = new ArrayList<>();
	
    @ManyToMany(cascade=CascadeType.ALL, mappedBy="activityEconomicalAccounts")
    @JsonIgnore
    private List<Activity> activities = new ArrayList<>();
    
    @ManyToMany(cascade=CascadeType.ALL, mappedBy="projectEconomicalAccounts")
    @JsonIgnore
    private List<Project> projects = new ArrayList<>(); 
    
    public EconomicAccount() {}

	public EconomicAccount(Long categoryID, String code, String categoryName, String name, String poz, String financialSrc,
			long expenseBaseYearBudget1, long expenseBaseYearBudget2, long expenseBaseYearBudget3,
			long expenseBaseYearBudget4, long expenseBaseYearOthers1, long expenseBaseYearOthers2,
			long expenseBaseYearOthers3, long expenseBaseYearOthers4, long expenseBaseYearPlus1Budget1,
			long expenseBaseYearPlus1Budget2, long expenseBaseYearPlus1Budget3, long expenseBaseYearPlus1Budget4,
			long expenseBaseYearPlus1Others1, long expenseBaseYearPlus1Others2, long expenseBaseYearPlus1Others3,
			long expenseBaseYearPlus1Others4, long expenseBaseYearPlus2Budget1, long expenseBaseYearPlus2Budget2,
			long expenseBaseYearPlus2Budget3, long expenseBaseYearPlus2Budget4, long expenseBaseYearPlus2Others1,
			long expenseBaseYearPlus2Others2, long expenseBaseYearPlus2Others3, long expenseBaseYearPlus2Others4,
			long expenseBaseYearPlus3Budget1, long expenseBaseYearPlus3Budget2, long expenseBaseYearPlus3Budget3,
			long expenseBaseYearPlus3Budget4, long expenseBaseYearPlus3Others1, long expenseBaseYearPlus3Others2,
			long expenseBaseYearPlus3Others3, long expenseBaseYearPlus3Others4, long sumExpenses123Budget,
			long sumExpenses123Others) {
		this.categoryID = categoryID;
		this.code = code;
		this.categoryName = categoryName;
		this.name = name;
		this.poz = poz;
		this.financialSrc = financialSrc;
		this.expenseBaseYearBudget1 = expenseBaseYearBudget1;
		this.expenseBaseYearBudget2 = expenseBaseYearBudget2;
		this.expenseBaseYearBudget3 = expenseBaseYearBudget3;
		this.expenseBaseYearBudget4 = expenseBaseYearBudget4;
		this.expenseBaseYearOthers1 = expenseBaseYearOthers1;
		this.expenseBaseYearOthers2 = expenseBaseYearOthers2;
		this.expenseBaseYearOthers3 = expenseBaseYearOthers3;
		this.expenseBaseYearOthers4 = expenseBaseYearOthers4;
		this.expenseBaseYearPlus1Budget1 = expenseBaseYearPlus1Budget1;
		this.expenseBaseYearPlus1Budget2 = expenseBaseYearPlus1Budget2;
		this.expenseBaseYearPlus1Budget3 = expenseBaseYearPlus1Budget3;
		this.expenseBaseYearPlus1Budget4 = expenseBaseYearPlus1Budget4;
		this.expenseBaseYearPlus1Others1 = expenseBaseYearPlus1Others1;
		this.expenseBaseYearPlus1Others2 = expenseBaseYearPlus1Others2;
		this.expenseBaseYearPlus1Others3 = expenseBaseYearPlus1Others3;
		this.expenseBaseYearPlus1Others4 = expenseBaseYearPlus1Others4;
		this.expenseBaseYearPlus2Budget1 = expenseBaseYearPlus2Budget1;
		this.expenseBaseYearPlus2Budget2 = expenseBaseYearPlus2Budget2;
		this.expenseBaseYearPlus2Budget3 = expenseBaseYearPlus2Budget3;
		this.expenseBaseYearPlus2Budget4 = expenseBaseYearPlus2Budget4;
		this.expenseBaseYearPlus2Others1 = expenseBaseYearPlus2Others1;
		this.expenseBaseYearPlus2Others2 = expenseBaseYearPlus2Others2;
		this.expenseBaseYearPlus2Others3 = expenseBaseYearPlus2Others3;
		this.expenseBaseYearPlus2Others4 = expenseBaseYearPlus2Others4;
		this.expenseBaseYearPlus3Budget1 = expenseBaseYearPlus3Budget1;
		this.expenseBaseYearPlus3Budget2 = expenseBaseYearPlus3Budget2;
		this.expenseBaseYearPlus3Budget3 = expenseBaseYearPlus3Budget3;
		this.expenseBaseYearPlus3Budget4 = expenseBaseYearPlus3Budget4;
		this.expenseBaseYearPlus3Others1 = expenseBaseYearPlus3Others1;
		this.expenseBaseYearPlus3Others2 = expenseBaseYearPlus3Others2;
		this.expenseBaseYearPlus3Others3 = expenseBaseYearPlus3Others3;
		this.expenseBaseYearPlus3Others4 = expenseBaseYearPlus3Others4;
		this.sumExpenses123Budget = sumExpenses123Budget;
		this.sumExpenses123Others = sumExpenses123Others;
	}
	
}

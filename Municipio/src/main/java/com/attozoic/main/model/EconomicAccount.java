package com.attozoic.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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

	private String code; // 400000
	private String name; // Текући расходи
	private String poz;
	
	private long expenseBaseYearBudget; // 2016
	private long expenseBaseYearOthers; // 2016
	private long expenseBaseYearPlus1Budget; // 2017
	private long expenseBaseYearPlus1Others; // 2017
	private long expenseBaseBudget; // 2018
	private long expenseBaseOthers; // 2018
	private long expenseBaseYearPlus3Budget; // 2019
	private long expenseBaseYearPlus3Others; // 2019
	private long sumExpenses123Budget;
	private long sumExpenses123Others;
	
    @ManyToMany(cascade=CascadeType.ALL, mappedBy="activityEconomicalAccount")
    @JsonIgnore
    private List<Activity> activities = new ArrayList<>();
    
    @ManyToMany(cascade=CascadeType.ALL, mappedBy="projectEconomicalAccount")
    @JsonIgnore
    private List<Project> projects = new ArrayList<>();
	
    public EconomicAccount() {}

	public EconomicAccount(String code, String name, String poz, long expenseBaseYearBudget, long expenseBaseYearOthers,
			long expenseBaseYearPlus1Budget, long expenseBaseYearPlus1Others, long expenseBaseBudget,
			long expenseBaseOthers, long expenseBaseYearPlus3Budget, long expenseBaseYearPlus3Others,
			long sumExpenses123Budget, long sumExpenses123Others) {
		super();
		this.code = code;
		this.name = name;
		this.poz = poz;
		this.expenseBaseYearBudget = expenseBaseYearBudget;
		this.expenseBaseYearOthers = expenseBaseYearOthers;
		this.expenseBaseYearPlus1Budget = expenseBaseYearPlus1Budget;
		this.expenseBaseYearPlus1Others = expenseBaseYearPlus1Others;
		this.expenseBaseBudget = expenseBaseBudget;
		this.expenseBaseOthers = expenseBaseOthers;
		this.expenseBaseYearPlus3Budget = expenseBaseYearPlus3Budget;
		this.expenseBaseYearPlus3Others = expenseBaseYearPlus3Others;
		this.sumExpenses123Budget = sumExpenses123Budget;
		this.sumExpenses123Others = sumExpenses123Others;
	}
	
}

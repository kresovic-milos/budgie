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
	private double expenseBaseYearBudget;
	
	private double expenseBaseYearOthers;
	// 2017
	private double expenseBaseYearPlus1Budget1;
	private double expenseBaseYearPlus1Budget2;
	private double expenseBaseYearPlus1Budget3;
	private double expenseBaseYearPlus1Budget4;
	
	private double sumExpensesBaseYearPlus1Budget;
	
	private double expenseBaseYearPlus1Others1;
	private double expenseBaseYearPlus1Others2;
	private double expenseBaseYearPlus1Others3;
	private double expenseBaseYearPlus1Others4;
	
	private double sumExpensesBaseYearPlus1Others;
	
	// 2018
	private double expenseBaseYearPlus2Budget;
	
	private double expenseBaseYearPlus2Others;
	// 2019
	private double expenseBaseYearPlus3Budget;
	
	private double expenseBaseYearPlus3Others;
	
	// Sum od Plus1 do Plus3
	private double sumExpenses123Budget;
	private double sumExpenses123Others;

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
	
	public List<Double> listRebBudget(){
		List<Double> listB = new ArrayList<>();
		for (RebalanceTwoFields rtf : rebalances) {
			double sumB = rtf.getValueB1() + rtf.getValueB2() + rtf.getValueB3() + rtf.getValueB4();
			listB.add(sumB);
		}
		return listB;
	}
	
	public double sumRebBudget() {
		double sum = 0;
		for (double d : listRebBudget()) {
			sum += d;
		}
		return sum;
	}
	
	public List<Double> listRebOthers() {
		List<Double> listO = new ArrayList<>();
		for (RebalanceTwoFields rtf : rebalances) {
			double sumO = rtf.getValueO1() + rtf.getValueO2() + rtf.getValueO3() + rtf.getValueO4();
			listO.add(sumO);
		}
		return listO;
	}
	
	public double sumRebOthers() {
		double sum = 0;
		for (double d : listRebOthers()) {
			sum += d;
		}
		return sum;
	}
	
}

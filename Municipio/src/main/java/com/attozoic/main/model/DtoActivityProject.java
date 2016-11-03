package com.attozoic.main.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class DtoActivityProject {

	private String type;
	private String name;

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
	
	//private List<RebalanceTwoFields> rebalances;
	
	private List<Double> listSumRebBudget = new ArrayList<>();
	private List<Double> listSumRebOthers = new ArrayList<>();
	
	public DtoActivityProject() {
		this.sumExpensesBaseYearPlus1Others = expenseBaseYearPlus1Others1 + expenseBaseYearPlus1Others2 + expenseBaseYearPlus1Others3 + expenseBaseYearPlus1Others4;
		this.sumExpensesBaseYearPlus1Budget = expenseBaseYearPlus1Budget1 + expenseBaseYearPlus1Budget2 + expenseBaseYearPlus1Budget3 + expenseBaseYearPlus1Budget4;
		this.sumExpenses123Budget = this.expenseBaseYearBudget + this.expenseBaseYearPlus1Budget1 + this.expenseBaseYearPlus1Budget2 + this.expenseBaseYearPlus1Budget3 + this.expenseBaseYearPlus1Budget4 + sumRebBudget() + this.expenseBaseYearPlus2Budget + this.expenseBaseYearPlus3Budget;
		this.sumExpenses123Others = this.expenseBaseYearOthers + this.expenseBaseYearPlus1Others1 + this.expenseBaseYearPlus1Others2 + this.expenseBaseYearPlus1Others3 + this.expenseBaseYearPlus1Others4 + sumRebOthers() + this.expenseBaseYearPlus2Others + this.expenseBaseYearPlus3Others;
	}
	
	public double sumRebBudget() {
		double sum = 0;
		for (Double value : listSumRebBudget) {
			sum += value;
		}
		return sum;
	}
	
	public double sumRebOthers() {
		double sum = 0;
		for (Double value : listSumRebOthers) {
			sum += value;
		}
		return sum;
	}
	
	public void DtoPlusDto(DtoActivityProject dto) {
		this.setExpenseBaseYearBudget(this.getExpenseBaseYearBudget() + dto.getExpenseBaseYearBudget());
		this.setExpenseBaseYearOthers(this.getExpenseBaseYearOthers() + dto.getExpenseBaseYearOthers());
		this.setExpenseBaseYearPlus1Budget1(this.getExpenseBaseYearPlus1Budget1() + dto.getExpenseBaseYearPlus1Budget1());
		this.setExpenseBaseYearPlus1Budget2(this.getExpenseBaseYearPlus1Budget2() + dto.getExpenseBaseYearPlus1Budget2());
		this.setExpenseBaseYearPlus1Budget3(this.getExpenseBaseYearPlus1Budget3() + dto.getExpenseBaseYearPlus1Budget3());
		this.setExpenseBaseYearPlus1Budget4(this.getExpenseBaseYearPlus1Budget4() + dto.getExpenseBaseYearPlus1Budget4());
		this.setExpenseBaseYearPlus1Others1(this.getExpenseBaseYearPlus1Others1() + dto.getExpenseBaseYearPlus1Others1());
		this.setExpenseBaseYearPlus1Others2(this.getExpenseBaseYearPlus1Others2() + dto.getExpenseBaseYearPlus1Others2());
		this.setExpenseBaseYearPlus1Others3(this.getExpenseBaseYearPlus1Others3() + dto.getExpenseBaseYearPlus1Others3());
		this.setExpenseBaseYearPlus1Others4(this.getExpenseBaseYearPlus1Others4() + dto.getExpenseBaseYearPlus1Others4());
		this.setExpenseBaseYearPlus2Budget(this.getExpenseBaseYearPlus2Budget() + dto.getExpenseBaseYearPlus2Budget());
		this.setExpenseBaseYearPlus2Others(this.getExpenseBaseYearPlus2Others() + dto.getExpenseBaseYearPlus2Others());
		this.setExpenseBaseYearPlus3Budget(this.getExpenseBaseYearPlus3Budget() + dto.getExpenseBaseYearPlus3Others());
		this.setSumExpenses123Budget(this.getSumExpenses123Budget() + dto.getSumExpenses123Budget());
		this.setSumExpenses123Others(this.getSumExpenses123Others() + dto.getSumExpenses123Others());
		this.setSumExpensesBaseYearPlus1Budget(this.getSumExpensesBaseYearPlus1Budget() + dto.getSumExpensesBaseYearPlus1Budget());
		this.setSumExpensesBaseYearPlus1Others(this.getSumExpensesBaseYearPlus1Others() + dto.getSumExpensesBaseYearPlus1Others());
	}
	
}

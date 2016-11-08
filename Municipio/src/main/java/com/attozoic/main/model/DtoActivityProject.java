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
	
	private List<DtoActivityProjectRebalanceObject> listDtoRebalances = new ArrayList<>();
	
	public DtoActivityProject() {}
	
	public List<DtoActivityProjectRebalanceObject> listPlusListDtoRebalance(List<DtoActivityProjectRebalanceObject> l) {
		List<DtoActivityProjectRebalanceObject> newList = new ArrayList<>();
		for (int i = 0; i < listDtoRebalances.size(); i++) {
			DtoActivityProjectRebalanceObject d1 = this.getListDtoRebalances().get(i);
			DtoActivityProjectRebalanceObject d2 = l.get(i);
			newList.add(d1.sum(d2));
		}
		return newList;
	}
	
//	public double sumRebBudget() {
//		double sum = 0;
//		for (Double value : listSumRebBudget) {
//			sum += value;
//		}
//		return sum;
//	}
//	
//	public double sumRebOthers() {
//		double sum = 0;
//		for (Double value : listSumRebOthers) {
//			sum += value;
//		}
//		return sum;
//	}
	
	public void dtoPlusDto(DtoActivityProject dto) {
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
		this.setExpenseBaseYearPlus3Others(this.getExpenseBaseYearPlus3Others() + dto.getExpenseBaseYearPlus3Others());
		this.setSumExpenses123Budget(this.getSumExpenses123Budget() + dto.getSumExpenses123Budget());
		this.setSumExpenses123Others(this.getSumExpenses123Others() + dto.getSumExpenses123Others());
		this.setSumExpensesBaseYearPlus1Budget(this.getSumExpensesBaseYearPlus1Budget() + dto.getSumExpensesBaseYearPlus1Budget());
		this.setSumExpensesBaseYearPlus1Others(this.getSumExpensesBaseYearPlus1Others() + dto.getSumExpensesBaseYearPlus1Others());
		this.setListDtoRebalances(this.listPlusListDtoRebalance(dto.getListDtoRebalances()));
	}
	
//	public void plusRebBudget(List<Double> list) {
//		for (int i = 0; i < this.getListSumRebBudget().size(); i++) {
//			this.getListSumRebBudget().set(i, (this.getListSumRebBudget().get(i) + list.get(i)));
//		}
//	}
//	
//	public void plusRebOthers(List<Double> list) {
//		for (int i = 0; i < this.getListSumRebOthers().size(); i++) {
//			this.getListSumRebOthers().set(i, (this.getListSumRebOthers().get(i) + list.get(i)));
//		}
//	}
	
}

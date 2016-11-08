package com.attozoic.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="activity_economic_accounts")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=ProjectEconomicAccount.class)
public class ProjectEconomicAccount extends SuperEntity {
	
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
	private String financialSourceBaseYearPlus1Budget;
	
	private double expenseBaseYearPlus1Others1;
	private double expenseBaseYearPlus1Others2;
	private double expenseBaseYearPlus1Others3;
	private double expenseBaseYearPlus1Others4;
	
	private double sumExpensesBaseYearPlus1Others;
	private String financialSourceBaseYearPlus1Others;
	
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
	@CollectionTable(name = "projectEconomicAccount_rebalances", joinColumns = @JoinColumn(name = "rebalance_uid"))
	@OrderColumn
	private List<RebalanceTwoFields> rebalances = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="project_uid")
    @NotFound(action=NotFoundAction.IGNORE)
    private Project project;
    
    public ProjectEconomicAccount() {}
	
	public List<DtoActivityProjectRebalanceObject> buildProjectEcAccDtoRebList(){
		List<DtoActivityProjectRebalanceObject> list = new ArrayList<>();
		for (RebalanceTwoFields rtf : rebalances) {
			DtoActivityProjectRebalanceObject dto = new DtoActivityProjectRebalanceObject();
			dto.setValueB1(rtf.getValueB1());
			dto.setValueB2(rtf.getValueB2());
			dto.setValueB3(rtf.getValueB3());
			dto.setValueB4(rtf.getValueB4());
			dto.setSumValueB(dto.sumValueBudget());
			dto.setValueO1(rtf.getValueO1());
			dto.setValueO2(rtf.getValueO2());
			dto.setValueO3(rtf.getValueO3());
			dto.setValueO4(rtf.getValueO4());
			dto.setSumValueO(dto.sumValueOthers());
			list.add(dto);
		}
		return list;
	}
    
//	public List<Double> listRebBudget(){
//		List<Double> listB = new ArrayList<>();
//		for (RebalanceTwoFields rtf : rebalances) {
//			double sumB = rtf.getValueB1() + rtf.getValueB2() + rtf.getValueB3() + rtf.getValueB4();
//			listB.add(sumB);
//		}
//		return listB;
//	}
//	
//	public double sumRebBudget() {
//		double sum = 0;
//		for (double d : listRebBudget()) {
//			sum += d;
//		}
//		return sum;
//	}
//	
//	public List<Double> listRebOthers() {
//		List<Double> listO = new ArrayList<>();
//		for (RebalanceTwoFields rtf : rebalances) {
//			double sumO = rtf.getValueO1() + rtf.getValueO2() + rtf.getValueO3() + rtf.getValueO4();
//			listO.add(sumO);
//		}
//		return listO;
//	}
//	
//	public double sumRebOthers() {
//		double sum = 0;
//		for (double d : listRebOthers()) {
//			sum += d;
//		}
//		return sum;
//	}
	
}

package com.attozoic.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="activities")
@Data
@EqualsAndHashCode(callSuper=true)
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

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="activity")
	@JsonManagedReference
    private List<ActivityGoal> activityGoals = new ArrayList<>();
	
    @ManyToOne
	@JoinColumn(name="programme_uid")
	@JsonBackReference
    private Programme programme;
	
    @ManyToOne
    @JoinColumn(name="function_id")
    @JsonIgnore
    private Function function;
    
    @ManyToOne
    @JoinColumn(name="head_id")
    @JsonIgnore
    private Head head;
    
    @ManyToOne
    @JoinColumn(name="authority_id")
    @JsonIgnore
    private Authority authority;
    
    @ManyToMany
    @JoinTable(
    		name="activity_finance",
    		joinColumns={@JoinColumn(name="activity_id")},
    		inverseJoinColumns={@JoinColumn(name="activityFinancialSource_id")}
    		)
    private List<ActivityFinancialSource> activityFinancialSources = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(
    		name="activity_economicalAcc",
    		joinColumns={@JoinColumn(name="activity_id")},
    		inverseJoinColumns={@JoinColumn(name="economicalAcc_id")}
    		)
    private List<EconomicAccount> activityEconomicalAccounts = new ArrayList<>();
	
	public Activity() {}
	
	public List<DtoProgrammeFinancialSource> buildDtoFinanceList() {
		List<DtoProgrammeFinancialSource> list = new ArrayList<>();
		for (ActivityFinancialSource financialSrc : activityFinancialSources) {
			DtoProgrammeFinancialSource dto = new DtoProgrammeFinancialSource();
			dto.setName(financialSrc.getName());
			dto.setSourceBaseYear(financialSrc.getSourceBaseYear());
			dto.setSourceBaseYearPlus1(financialSrc.getSourceBaseYearPlus1());
			dto.setSourceBaseYearPlus2(financialSrc.getSourceBaseYearPlus2());
			dto.setSourceBaseYearPlus3(financialSrc.getSourceBaseYearPlus3());
			dto.setSumSources123(financialSrc.getSumSources123());
			dto.setListSourceRebalance(financialSrc.listRebDouble());
			list.add(dto);
		}
		return list;
	}

	public DtoActivityProject buildActivityDTO() {
		DtoActivityProject dto = new DtoActivityProject();
		dto.setType("Активност");
		dto.setName(getCategoryName());
		for (EconomicAccount economicAccount : activityEconomicalAccounts) {
			dto.setExpenseBaseYearBudget(dto.getExpenseBaseYearBudget() + economicAccount.getExpenseBaseYearBudget()); 
			dto.setExpenseBaseYearOthers(dto.getExpenseBaseYearOthers() + economicAccount.getExpenseBaseYearOthers());
			dto.setExpenseBaseYearPlus1Budget1(dto.getExpenseBaseYearPlus1Budget1() + economicAccount.getExpenseBaseYearPlus1Budget1());
			dto.setExpenseBaseYearPlus1Budget2(dto.getExpenseBaseYearPlus1Budget2() + economicAccount.getExpenseBaseYearPlus1Budget2());
			dto.setExpenseBaseYearPlus1Budget3(dto.getExpenseBaseYearPlus1Budget3() + economicAccount.getExpenseBaseYearPlus1Budget3());
			dto.setExpenseBaseYearPlus1Budget4(dto.getExpenseBaseYearPlus1Budget4() + economicAccount.getExpenseBaseYearPlus1Budget4());
			dto.setSumExpensesBaseYearPlus1Budget(dto.getSumExpensesBaseYearPlus1Budget() + economicAccount.getSumExpensesBaseYearPlus1Budget());
			dto.setExpenseBaseYearPlus1Others1(dto.getExpenseBaseYearPlus1Others1() + economicAccount.getExpenseBaseYearPlus1Others1());
			dto.setExpenseBaseYearPlus1Others2(dto.getExpenseBaseYearPlus1Others2() + economicAccount.getExpenseBaseYearPlus1Others2());
			dto.setExpenseBaseYearPlus1Others3(dto.getExpenseBaseYearPlus1Others3() + economicAccount.getExpenseBaseYearPlus1Others3());
			dto.setExpenseBaseYearPlus1Others4(dto.getExpenseBaseYearPlus1Others4() + economicAccount.getExpenseBaseYearPlus1Others4());
			dto.setSumExpensesBaseYearPlus1Others(dto.getSumExpensesBaseYearPlus1Others() + economicAccount.getSumExpensesBaseYearPlus1Others());
			List<Double> ldb = economicAccount.listRebBudget();
			for (Double value : ldb) {
				dto.getListSumRebBudget().add(value);
			}
			List<Double> ldo = economicAccount.listRebOthers();
			for (Double value : ldo) {
				dto.getListSumRebOthers().add(value);
			}
			dto.setExpenseBaseYearPlus2Budget(dto.getExpenseBaseYearPlus2Budget() + economicAccount.getExpenseBaseYearPlus2Budget());
			dto.setExpenseBaseYearPlus2Budget(dto.getExpenseBaseYearPlus2Budget() + economicAccount.getExpenseBaseYearPlus2Budget());
			dto.setExpenseBaseYearPlus3Budget(dto.getExpenseBaseYearPlus3Budget() + economicAccount.getExpenseBaseYearPlus3Budget());
			dto.setExpenseBaseYearPlus3Budget(dto.getExpenseBaseYearPlus3Budget() + economicAccount.getExpenseBaseYearPlus3Budget());
			dto.setSumExpenses123Budget(dto.getSumExpenses123Budget() + economicAccount.getSumExpenses123Budget());
			dto.setSumExpenses123Others(dto.getSumExpenses123Others() + economicAccount.getSumExpenses123Others());
		}
		return dto;
	}
	
}

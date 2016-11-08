package com.attozoic.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="activities")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=Activity.class)
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

	// Function
	Long categoryFunctionID;
	String function;
	// Head
	Long categoryHeadID;
	String head;
	// Authority
	Long categoryAuthorityID;
	String authority;
    
    @ManyToOne
	@JoinColumn(name="programme_uid")
    @NotFound(action=NotFoundAction.IGNORE)
    private Programme programme;

    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="activity")
    private List<ActivityGoal> activityGoals = new ArrayList<>();
    
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="activity")
    private List<ActivityEconomicAccount> activityEconomicAccounts = new ArrayList<>();
	
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="activity")
    private List<ActivityFinancialSource> activityFinancialSources = new ArrayList<>();
    
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
		for (ActivityEconomicAccount activityEconomicAccount : activityEconomicAccounts) {
			dto.setExpenseBaseYearBudget(dto.getExpenseBaseYearBudget() + activityEconomicAccount.getExpenseBaseYearBudget()); 
			dto.setExpenseBaseYearOthers(dto.getExpenseBaseYearOthers() + activityEconomicAccount.getExpenseBaseYearOthers());
			dto.setExpenseBaseYearPlus1Budget1(dto.getExpenseBaseYearPlus1Budget1() + activityEconomicAccount.getExpenseBaseYearPlus1Budget1());
			dto.setExpenseBaseYearPlus1Budget2(dto.getExpenseBaseYearPlus1Budget2() + activityEconomicAccount.getExpenseBaseYearPlus1Budget2());
			dto.setExpenseBaseYearPlus1Budget3(dto.getExpenseBaseYearPlus1Budget3() + activityEconomicAccount.getExpenseBaseYearPlus1Budget3());
			dto.setExpenseBaseYearPlus1Budget4(dto.getExpenseBaseYearPlus1Budget4() + activityEconomicAccount.getExpenseBaseYearPlus1Budget4());
			dto.setSumExpensesBaseYearPlus1Budget(dto.getSumExpensesBaseYearPlus1Budget() + activityEconomicAccount.getSumExpensesBaseYearPlus1Budget());
			dto.setExpenseBaseYearPlus1Others1(dto.getExpenseBaseYearPlus1Others1() + activityEconomicAccount.getExpenseBaseYearPlus1Others1());
			dto.setExpenseBaseYearPlus1Others2(dto.getExpenseBaseYearPlus1Others2() + activityEconomicAccount.getExpenseBaseYearPlus1Others2());
			dto.setExpenseBaseYearPlus1Others3(dto.getExpenseBaseYearPlus1Others3() + activityEconomicAccount.getExpenseBaseYearPlus1Others3());
			dto.setExpenseBaseYearPlus1Others4(dto.getExpenseBaseYearPlus1Others4() + activityEconomicAccount.getExpenseBaseYearPlus1Others4());
			dto.setSumExpensesBaseYearPlus1Others(dto.getSumExpensesBaseYearPlus1Others() + activityEconomicAccount.getSumExpensesBaseYearPlus1Others());
			List<DtoRebalanceTwoFields> l = activityEconomicAccount.buildActivityEcAccDtoRebList();
			if (dto.getListDtoRebalances().isEmpty()) {
				dto.setListDtoRebalances(l);
			} else {
				List<DtoRebalanceTwoFields> l1 = dto.listPlusListDtoRebalance(l);
				dto.setListDtoRebalances(l1);
			}
			dto.setExpenseBaseYearPlus2Budget(dto.getExpenseBaseYearPlus2Budget() + activityEconomicAccount.getExpenseBaseYearPlus2Budget());
			dto.setExpenseBaseYearPlus2Others(dto.getExpenseBaseYearPlus2Others() + activityEconomicAccount.getExpenseBaseYearPlus2Others());
			dto.setExpenseBaseYearPlus3Budget(dto.getExpenseBaseYearPlus3Budget() + activityEconomicAccount.getExpenseBaseYearPlus3Budget());
			dto.setExpenseBaseYearPlus3Others(dto.getExpenseBaseYearPlus3Others() + activityEconomicAccount.getExpenseBaseYearPlus3Others());
			dto.setSumExpenses123Budget(dto.getSumExpenses123Budget() + activityEconomicAccount.getSumExpenses123Budget());
			dto.setSumExpenses123Others(dto.getSumExpenses123Others() + activityEconomicAccount.getSumExpenses123Others());
		}
		return dto;
	}

	public Activity(Long categoryID, String code, String ordNumber, String categoryName, String name, String purpose,
			String rudiment, String description, String anex, String responsibleAuthority, Long categoryFunctionID,
			String function, Long categoryHeadID, String head, Long categoryAuthorityID, String authority) {
		super();
		this.categoryID = categoryID;
		this.code = code;
		this.ordNumber = ordNumber;
		this.categoryName = categoryName;
		this.name = name;
		this.purpose = purpose;
		this.rudiment = rudiment;
		this.description = description;
		this.anex = anex;
		this.responsibleAuthority = responsibleAuthority;
		this.categoryFunctionID = categoryFunctionID;
		this.function = function;
		this.categoryHeadID = categoryHeadID;
		this.head = head;
		this.categoryAuthorityID = categoryAuthorityID;
		this.authority = authority;
	}
	
}

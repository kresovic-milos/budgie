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
@Table(name="projects")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=Project.class)
public class Project extends SuperEntity {
    
	private String code;
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
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="project")
    private List<ProjectGoal> projectGoals = new ArrayList<>();
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="project")
    private List<ProjectEconomicAccount> projectEconomicAccounts = new ArrayList<>();
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="project")
    private List<ProjectFinancialSource> financialSources = new ArrayList<>();
	
	public Project() {}

	public List<DtoProgrammeFinancialSource> buildDtoFinanceList() {
		List<DtoProgrammeFinancialSource> list = new ArrayList<>();
		for (ProjectFinancialSource financialSrc : financialSources) {
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
	
	public DtoProgrammeFinancialSource buildProjectFinanceDto(int num) {
		DtoProgrammeFinancialSource dto = new DtoProgrammeFinancialSource();
		List<DtoProgrammeFinancialSource> list = buildDtoFinanceList();
		if (num > 0) {
			List<Double> l = new ArrayList<>();
			for (int i = 0; i < num; i++) {
				l.add(new Double(0));
			}
			dto.setListSourceRebalance(l);
		}
		for (DtoProgrammeFinancialSource dtoProgrammeFinancialSource : list) {
			dto.dtoFinancePlusDtoFinance(dtoProgrammeFinancialSource);
		}
		return dto;
	}

	public DtoActivityProject buildProjectDTO() {
		DtoActivityProject dto = new DtoActivityProject();
		dto.setType("Пројекат");
		dto.setName(getName());
		for (ProjectEconomicAccount projectEconomicAccounts : projectEconomicAccounts) {
			dto.setExpenseBaseYearBudget(dto.getExpenseBaseYearBudget() + projectEconomicAccounts.getExpenseBaseYearBudget()); 
			dto.setExpenseBaseYearOthers(dto.getExpenseBaseYearOthers() + projectEconomicAccounts.getExpenseBaseYearOthers());
			dto.setExpenseBaseYearPlus1Budget1(dto.getExpenseBaseYearPlus1Budget1() + projectEconomicAccounts.getExpenseBaseYearPlus1Budget1());
			dto.setExpenseBaseYearPlus1Budget2(dto.getExpenseBaseYearPlus1Budget2() + projectEconomicAccounts.getExpenseBaseYearPlus1Budget2());
			dto.setExpenseBaseYearPlus1Budget3(dto.getExpenseBaseYearPlus1Budget3() + projectEconomicAccounts.getExpenseBaseYearPlus1Budget3());
			dto.setExpenseBaseYearPlus1Budget4(dto.getExpenseBaseYearPlus1Budget4() + projectEconomicAccounts.getExpenseBaseYearPlus1Budget4());
			dto.setSumExpensesBaseYearPlus1Budget(dto.getSumExpensesBaseYearPlus1Budget() + projectEconomicAccounts.getSumExpensesBaseYearPlus1Budget());
			dto.setExpenseBaseYearPlus1Others1(dto.getExpenseBaseYearPlus1Others1() + projectEconomicAccounts.getExpenseBaseYearPlus1Others1());
			dto.setExpenseBaseYearPlus1Others2(dto.getExpenseBaseYearPlus1Others2() + projectEconomicAccounts.getExpenseBaseYearPlus1Others2());
			dto.setExpenseBaseYearPlus1Others3(dto.getExpenseBaseYearPlus1Others3() + projectEconomicAccounts.getExpenseBaseYearPlus1Others3());
			dto.setExpenseBaseYearPlus1Others4(dto.getExpenseBaseYearPlus1Others4() + projectEconomicAccounts.getExpenseBaseYearPlus1Others4());
			dto.setSumExpensesBaseYearPlus1Others(dto.getSumExpensesBaseYearPlus1Others() + projectEconomicAccounts.getSumExpensesBaseYearPlus1Others());
			List<DtoRebalanceTwoFields> l = projectEconomicAccounts.buildProjectEcAccDtoRebList();
			if (dto.getListDtoRebalances().isEmpty()) {
				dto.setListDtoRebalances(l);
			} else {
				List<DtoRebalanceTwoFields> l1 = dto.listPlusListDtoRebalance(l);
				dto.setListDtoRebalances(l1);
			}
			dto.setExpenseBaseYearPlus2Budget(dto.getExpenseBaseYearPlus2Budget() + projectEconomicAccounts.getExpenseBaseYearPlus2Budget());
			dto.setExpenseBaseYearPlus2Others(dto.getExpenseBaseYearPlus2Others() + projectEconomicAccounts.getExpenseBaseYearPlus2Others());
			dto.setExpenseBaseYearPlus3Budget(dto.getExpenseBaseYearPlus3Budget() + projectEconomicAccounts.getExpenseBaseYearPlus3Budget());
			dto.setExpenseBaseYearPlus3Others(dto.getExpenseBaseYearPlus3Others() + projectEconomicAccounts.getExpenseBaseYearPlus3Others());
			dto.setSumExpenses123Budget(dto.getSumExpenses123Budget() + projectEconomicAccounts.getSumExpenses123Budget());
			dto.setSumExpenses123Others(dto.getSumExpenses123Others() + projectEconomicAccounts.getSumExpenses123Others());
		}
		return dto;
	}
    
}

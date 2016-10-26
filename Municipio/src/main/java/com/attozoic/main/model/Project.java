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
@Table(name="projects")
@Data
@EqualsAndHashCode(callSuper=true)
public class Project extends SuperEntity {
    
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="project")
	@JsonManagedReference
    private List<ProjectGoal> projectGoals;
	
    @ManyToOne
	@JoinColumn(name="programme_uid")
	@JsonBackReference
    private Programme programme;
    
    @ManyToOne
    @JoinColumn(name="function_id")
    @JsonIgnore
    private Function function;
    
	private String code;
	private String name;
    private String budgetUser;
    private String purpose;
	private String rudiment;
	private String description;
	private String anex;
	private String responsibleAuthority;
	
	private Long sumExpenses;
	private Long sumFinancialSources;
	
	@ManyToMany
    @JoinTable(
    		name="project_finance",
    		joinColumns={@JoinColumn(name="project_id")},
    		inverseJoinColumns={@JoinColumn(name="financialSource_id")}
    		)
    private List<ProjectFinancialSource> financialSources;
	
    @ManyToMany
    @JoinTable(
    		name="project_economicalAcc",
    		joinColumns={@JoinColumn(name="project_id")},
    		inverseJoinColumns={@JoinColumn(name="economicalAcc_id")}
    		)
    private List<EconomicAccount> projectEconomicalAccount = new ArrayList<>();
	
	public Project() {}

	public Project(String budgetUser, String rudiment, String description, String anex, String responsibleAuthority,
			Long sumExpenses, Long sumFinancialSources) {
		super();
		this.budgetUser = budgetUser;
		this.rudiment = rudiment;
		this.description = description;
		this.anex = anex;
		this.responsibleAuthority = responsibleAuthority;
		this.sumExpenses = sumExpenses;
		this.sumFinancialSources = sumFinancialSources;
	}
    
}

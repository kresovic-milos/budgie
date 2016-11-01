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
    
	private String organizationalUnit; // RAZDEO
    private String budgetUser; // GLAVA   
    
    private String purpose;
	private String rudiment;
	private String description;
	private String anex;
	private String responsibleAuthority;
	
	private Long sumExpenses;
	private Long sumFinancialSources;
    
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

	public Activity(Long categoryID, String code, String categoryName, String ordNumber, String name, String organizationalUnit, String budgetUser, String purpose, String rudiment,
			String description, String anex, String responsibleAuthority, Long sumExpenses, Long sumFinancialSources) {
		this.categoryID = categoryID;
		this.code = code;
		this.categoryName = categoryName;
		this.ordNumber = ordNumber;
		this.name = name;
		this.organizationalUnit = organizationalUnit;
		this.budgetUser = budgetUser;
		this.purpose = purpose;
		this.rudiment = rudiment;
		this.description = description;
		this.anex = anex;
		this.responsibleAuthority = responsibleAuthority;
		this.sumExpenses = sumExpenses;
		this.sumFinancialSources = sumFinancialSources;
	}

}

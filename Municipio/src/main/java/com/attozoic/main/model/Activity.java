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
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="activities")
@Data
@EqualsAndHashCode(callSuper=true)
public class Activity extends SuperEntity { 
	
	private String code; // 1101-0001
	private String ordNumber; // ПА_1
	private String name; // Стратешко, просторно и урбанистичко планирање
    
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="activity")
	@JsonManagedReference
    private List<ActivityGoal> activityGoals;
	
    @ManyToOne
	@JoinColumn(name="programme_uid")
	@JsonBackReference
    private Programme programme;
	
    @ManyToOne
    @JoinColumn(name="function_id")
    @JsonBackReference(value = "secondParent")
    private Function function;
    
    @ManyToMany
    @JoinTable(
    		name="activity_finance",
    		joinColumns={@JoinColumn(name="activity_id")},
    		inverseJoinColumns={@JoinColumn(name="activityFinancialSource_id")}
    		)
    private List<ActivityFinancialSource> activityFinancialSources = new ArrayList<>();
    
    private String budgetUser;
    private String purpose;
	private String rudiment;
	private String description;
	private String anex;
	private String responsibleAuthority;
	
	private Long sumExpenses;
	private Long sumFinancialSources;
	
	public Activity() {}

	public Activity(String code, String ordNumber, String name, String budgetUser, String purpose, String rudiment,
			String description, String anex, String responsibleAuthority, Long sumExpenses, Long sumFinancialSources) {
		super();
		this.code = code;
		this.ordNumber = ordNumber;
		this.name = name;
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

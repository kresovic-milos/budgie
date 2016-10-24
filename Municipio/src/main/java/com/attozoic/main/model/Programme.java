package com.attozoic.main.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="programmes")
@Data
@EqualsAndHashCode(callSuper=true)
public class Programme extends SuperEntity {
	
	private String code; // 1101
	private String ordNumber; // ПГ_1
	private String name; // Програм_1__Локални_развој_и_просторно_планирање
	private String purpose; // Планско одређивање праваца развоја локалне средине и ефикасно администрирање захтева за издавање грађевинских дозвола
	
	@ManyToOne
	@JoinColumn(name="sector_uid")
	@JsonBackReference
    private Sector sector;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="programme")
    @JsonManagedReference
	private List<ProgrammeGoal> programmeGoals;
    
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="programme")
    @JsonManagedReference
    private List<Activity> activities;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="programme")
    @JsonManagedReference
    private List<Activity> projects;
	
	private String rudiment;
	private String description;
	private String budgetUser;
	private String responsibleAuthority;
	private Long sumExpenses;
	private Long sumFinancialSources;
	
	public Programme() {}

	public Programme(String code, String ordNumber, String name, String purpose, String rudiment,
			String description, String budgetUser, String responsibleAuthority, Long sumExpenses,
			Long sumFinancialSources) {
		this.code = code;
		this.ordNumber = ordNumber;
		this.name = name;
		this.purpose = purpose;
		this.rudiment = rudiment;
		this.description = description;
		this.budgetUser = budgetUser;
		this.responsibleAuthority = responsibleAuthority;
		this.sumExpenses = sumExpenses;
		this.sumFinancialSources = sumFinancialSources;
	}
}

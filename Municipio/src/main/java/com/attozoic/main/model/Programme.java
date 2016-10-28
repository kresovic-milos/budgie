package com.attozoic.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name="programmes")
@Data
@EqualsAndHashCode(callSuper=true)
public class Programme extends SuperEntity {
	
	private String code; // 1101
	private String ordNumber; // ПГ_1
	@Column(length = 512)
	private String name; // Програм_1__Локални_развој_и_просторно_планирање
	@Column(length = 2048)
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
    private List<Project> projects;
	
    @ManyToMany
    @JoinTable(
    		name="programme_finance",
    		joinColumns={@JoinColumn(name="programme_id")},
    		inverseJoinColumns={@JoinColumn(name="programmeFinancialSource_id")}
    		)
    private List<ProgrammeFinancialSource> programmeFinancialSources = new ArrayList<>();
	
    @Column(length = 2048)
	private String rudiment;
    @Column(length = 2048)
	private String description;
    @Column(length = 2048)
	private String budgetUser;
    @Column(length = 2048)
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

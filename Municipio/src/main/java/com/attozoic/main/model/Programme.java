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
	
	private Long categoryID;
	
	private String code;
	private String ordNumber;
	@Column(length = 512)
	private String name; 
	@Column(length = 2048)
	private String purpose; 
	
    @Column(length = 2048)
	private String rudiment;
    @Column(length = 2048)
	private String description;
    @Column(length = 2048)
	private String budgetUser;
    @Column(length = 2048)
	private String responsibleAuthority;
	
	@ManyToOne
	@JoinColumn(name="sector_uid")
	@JsonBackReference
    private Sector sector;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="programme")
    @JsonManagedReference
	private List<ProgrammeGoal> programmeGoals = new ArrayList<>();
    
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="programme")
    @JsonManagedReference
    private List<Activity> activities = new ArrayList<>();
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="programme")
    @JsonManagedReference
    private List<Project> projects = new ArrayList<>();
	
    @ManyToMany
    @JoinTable(
    		name="programme_finance",
    		joinColumns={@JoinColumn(name="programme_id")},
    		inverseJoinColumns={@JoinColumn(name="programmeFinancialSource_id")}
    		)
    private List<ProgrammeFinancialSource> programmeFinancialSources = new ArrayList<>();
	
	public Programme() {}

}

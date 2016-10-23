package com.attozoic.main.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.attozoic.categories.model.CategoryProgramme;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name="programmes")
@Data
public class Programme {

	@Id
	@GeneratedValue
	private Long uid;
	
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
    @PrimaryKeyJoinColumn
	private CategoryProgramme categoryProgramme;
    
    @Column(name= "category_programme_id", insertable=false, updatable=false)
	private Long categoryProgrammeId;
	
	@ManyToOne
	@JoinColumn(name="sector_uid")
	@JsonManagedReference
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
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "create_date")
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "update_date")
	private Date updateDate;
	
	public Programme() {}

	
	
	
	public Programme(CategoryProgramme categoryProgramme, String rudiment, String description, String budgetUser,
			String responsibleAuthority, Long sumExpenses, Long sumFinancialSources) {
		this.categoryProgramme = categoryProgramme;
		this.rudiment = rudiment;
		this.description = description;
		this.budgetUser = budgetUser;
		this.responsibleAuthority = responsibleAuthority;
		this.sumExpenses = sumExpenses;
		this.sumFinancialSources = sumFinancialSources;
	}
	
}

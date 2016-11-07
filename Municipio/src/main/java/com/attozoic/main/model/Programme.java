package com.attozoic.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name="programmes")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid")
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
	@NotFound(action=NotFoundAction.IGNORE)
    private Sector sector;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="programme")
	private List<ProgrammeGoal> programmeGoals = new ArrayList<>();
    
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="programme")
    private List<Activity> activities = new ArrayList<>();
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="programme")
    private List<Project> projects = new ArrayList<>();
	
	public Programme() {}

	public Programme(Long categoryID, String code, String ordNumber, String name, String purpose, String rudiment,
			String description, String budgetUser, String responsibleAuthority) {
		super();
		this.categoryID = categoryID;
		this.code = code;
		this.ordNumber = ordNumber;
		this.name = name;
		this.purpose = purpose;
		this.rudiment = rudiment;
		this.description = description;
		this.budgetUser = budgetUser;
		this.responsibleAuthority = responsibleAuthority;
	}
	
}

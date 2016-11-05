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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="programme_goals")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "uid")
public class ProgrammeGoal extends SuperEntity {
	
	private Long categoryID;
	
	private String code;
	private String name;
	
    @ManyToOne
	@JoinColumn(name="programme_uid")
    //@JsonBackReference
    private Programme programme;
    
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="programmeGoal", orphanRemoval=true)
	//@JsonManagedReference
    private List<ProgrammeGoalIndicator> programmeGoalIndicators = new ArrayList<>();
	
	public ProgrammeGoal() {}

}

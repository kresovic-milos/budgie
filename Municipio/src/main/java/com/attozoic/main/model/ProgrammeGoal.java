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
@Table(name="programme_goals")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=ProgrammeGoal.class)
public class ProgrammeGoal extends SuperEntity {
	
	private Long categoryID;
	
	private String code;
	private String name;
	
    @ManyToOne
	@JoinColumn(name="programme_uid")
    @NotFound(action=NotFoundAction.IGNORE)
    private Programme programme;
    
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="programmeGoal", orphanRemoval=true)
    private List<ProgrammeGoalIndicator> programmeGoalIndicators = new ArrayList<>();
	
	public ProgrammeGoal() {}

	public ProgrammeGoal(Long categoryID, String code, String name) {
		super();
		this.categoryID = categoryID;
		this.code = code;
		this.name = name;
	}
	
}

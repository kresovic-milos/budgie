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
@Table(name="programme_goals")
@Data
@EqualsAndHashCode(callSuper=true)
public class ProgrammeGoal extends SuperEntity {
	
	private String code;
	private String name;
	
    @ManyToOne
	@JoinColumn(name="programme_uid")
    @JsonBackReference
    private Programme programme;
    
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="programmeGoal")
	@JsonManagedReference
    private List<ProgrammeGoalIndicator> programmeGoalIndicators;
	
	public ProgrammeGoal() {}

	public ProgrammeGoal(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
}

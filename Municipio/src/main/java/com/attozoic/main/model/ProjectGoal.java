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
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="project_goals")
@Data
@EqualsAndHashCode(callSuper=true)
public class ProjectGoal extends SuperEntity {
	
	private String name;
	
    @ManyToOne
	@JoinColumn(name="project_uid")
	@JsonBackReference
    private Project project;
    
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="projectGoal")
	@JsonManagedReference
    private List<ProjectGoalIndicator> projectGoalIndicators = new ArrayList<>();
	
	
    public ProjectGoal() {}

	public ProjectGoal(String name) {
		this.name = name;
	}
    

    
}

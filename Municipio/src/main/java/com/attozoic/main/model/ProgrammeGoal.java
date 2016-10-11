package com.attozoic.main.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.attozoic.categories.model.CategoryProgrammeGoal;
import com.attozoic.categories.model.CategoryProgrammeGoalIndicator;

import lombok.Data;

@Entity
@Table(name = "programme_goal")
@Data
public class ProgrammeGoal {
	
	@Id
	@GeneratedValue
	private Long uid;
	
	@OneToOne
	private CategoryProgrammeGoal categoryProgrammeGoal;
	
	@OneToMany
	@JoinColumn(name = "indicators")
	private List<CategoryProgrammeGoalIndicator> categoryProgrammeGoalIndicators;
	
	public ProgrammeGoal() {}
	
	public ProgrammeGoal(CategoryProgrammeGoal categoryProgrammeGoal, List<CategoryProgrammeGoalIndicator> categoryProgrammeGoalIndicators) {
		this.categoryProgrammeGoal = categoryProgrammeGoal;
		this.categoryProgrammeGoalIndicators = categoryProgrammeGoalIndicators;
	}

}

package com.attozoic.categories.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "category_programme_goal_indicators")
@Data
@EqualsAndHashCode(callSuper=true)
public class CategoryProgrammeGoalIndicator extends CategorySuperEntity {

	@Column(length = 512)
	private String name;

	@Transient
	private Long categoryProgrammeGoalID;
	
	@ManyToOne
	@JoinColumn(name="categoryProgrammeGoal_uid")
	@JsonBackReference
	private CategoryProgrammeGoal categoryProgramGoal;
	
	public CategoryProgrammeGoalIndicator() {}
	
}


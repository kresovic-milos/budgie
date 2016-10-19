package com.attozoic.categories.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "category_programme_goal_indicators")
public class CategoryProgrammeGoalIndicator {

	@Id
	@GeneratedValue//(strategy = GenerationType.IDENTITY)
	private Long uid; 
	private String name;

	public CategoryProgrammeGoalIndicator(){}
	
	public CategoryProgrammeGoalIndicator(String name) {
		this.name = name;
	}
	
}


package com.attozoic.categories.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
@Table(name = "category_programme_goal_indicators")
public class CategoryProgrammeGoalIndicator {

	@Id
	@GeneratedValue//(strategy = GenerationType.IDENTITY)
	private Long uid; 
	private String name;

	@ManyToOne
	@JoinColumn(name="categoryProgrammeGoal_uid")
	@JsonBackReference
	private CategoryProgrammeGoal categoryProgramGoal;
	
	public CategoryProgrammeGoalIndicator(){}
	
	public CategoryProgrammeGoalIndicator(String name) {
		this.name = name;
	}
	
//	@Override
//	public String toString() {
//		return uid + "; " + name ;
//	}
	
}


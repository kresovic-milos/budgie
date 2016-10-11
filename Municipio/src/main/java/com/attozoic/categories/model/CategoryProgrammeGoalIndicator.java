package com.attozoic.categories.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "category_programme_goal_indicator")
@Data
public class CategoryProgrammeGoalIndicator {

	@Id
	@GeneratedValue//(strategy=GenerationType.IDENTITY)
	//@Column(name="indicator_id")
	private Long uid; 

	private String name; 

	//@ManyToOne
	//@JoinColumn(name="goal_id")
	//@JsonManagedReference
	//private CategoryProgrammeGoal goal;
	
	public CategoryProgrammeGoalIndicator(){}
	
	public CategoryProgrammeGoalIndicator(String name) {
		this.name = name;
	}
	
//	@Override
//	public String toString() {
//		return uid + "; " + name ;
//	}
	
}


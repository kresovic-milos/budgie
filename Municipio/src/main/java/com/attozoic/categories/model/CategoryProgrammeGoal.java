package com.attozoic.categories.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "category_programme_goal")
@Data
public class CategoryProgrammeGoal {

	@Id
	@GeneratedValue//(strategy=GenerationType.IDENTITY)
	//@Column(name="goal_id")
	private Long uid;
	
	private String code;
	
	private String name;
	
	//@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="goal")
	//@JsonBackReference
	//private List<CategoryProgrammeGoalIndicator> indicators;
	
	public CategoryProgrammeGoal(){}
	
	public CategoryProgrammeGoal(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
//	@Override
//	public String toString() {
//		return uid + "; " + code + "; " + name;
//	}
}

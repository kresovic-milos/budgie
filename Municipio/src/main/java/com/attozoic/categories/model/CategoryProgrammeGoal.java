package com.attozoic.categories.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "category_programme_goals")
public class CategoryProgrammeGoal {

	@Id
	@GeneratedValue//(strategy=GenerationType.IDENTITY)
	private Long uid;
	private String code;
	private String name;

	public CategoryProgrammeGoal(){}
	
	public CategoryProgrammeGoal(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
}

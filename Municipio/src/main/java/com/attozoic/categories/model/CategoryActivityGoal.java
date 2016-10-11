package com.attozoic.categories.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "category_activity_goal")
@Data
public class CategoryActivityGoal {

	@Id
	@GeneratedValue
	private Long uid;
	private String code;
	private String name;
	
	public CategoryActivityGoal() {}
	
	public CategoryActivityGoal(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
}

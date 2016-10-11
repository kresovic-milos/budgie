package com.attozoic.categories.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "category_activity_goal_indicator")
@Data
public class CategoryActivityGoalIndicator {

	@Id
	@GeneratedValue
	private Long uid;
	private String name;
	
	public CategoryActivityGoalIndicator() {}
	
	public CategoryActivityGoalIndicator(String name) {
		this.name = name;
	}
	
}

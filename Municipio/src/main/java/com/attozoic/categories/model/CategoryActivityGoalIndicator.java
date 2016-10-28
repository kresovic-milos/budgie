package com.attozoic.categories.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "category_activity_goal_indicators")
@Data
@EqualsAndHashCode(callSuper=true)
public class CategoryActivityGoalIndicator extends CategorySuperEntity {

	@Id
	@GeneratedValue
	private Long uid;
	@Column(length = 512)
	private String name;
	
	@Transient
	private Long categoryActivitiGoalID;
	
	@ManyToOne
	@JoinColumn(name="categoryActivityGoal_uid")
	@JsonBackReference
	private CategoryActivityGoal categoryActivityGoal;
	
	public CategoryActivityGoalIndicator() {}
	
	public CategoryActivityGoalIndicator(String name) {
		this.name = name;
	}
	
}

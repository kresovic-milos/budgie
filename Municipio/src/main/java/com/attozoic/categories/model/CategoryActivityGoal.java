package com.attozoic.categories.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "category_activity_goals")
@Data
@EqualsAndHashCode(callSuper=true)
public class CategoryActivityGoal extends CategorySuperEntity {

	private String code;
	@Column(length = 512)
	private String name;
	
	@Transient
	private Long categoryActivityID;
	
	@ManyToOne
	@JoinColumn(name="categoryActivity_uid")
	@JsonBackReference
	private CategoryActivity categoryActivity;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="categoryActivityGoal")
	@JsonManagedReference
	private List<CategoryActivityGoalIndicator> categoryActivityGoalIndicators;
	
	public CategoryActivityGoal() {}
	
}

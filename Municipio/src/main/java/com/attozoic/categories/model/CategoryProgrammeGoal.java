package com.attozoic.categories.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="categoryProgramGoal")
	@JsonManagedReference
	private List<CategoryProgrammeGoalIndicator> categoryProgrameGoalIndicators;
	
	@ManyToOne
	@JoinColumn(name="categoryPrograme_uid")
	@JsonBackReference
	private CategoryProgramme categoryProgramme;
	
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

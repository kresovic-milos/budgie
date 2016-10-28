package com.attozoic.categories.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "category_programme_goals")
@Data
@EqualsAndHashCode(callSuper=true)
public class CategoryProgrammeGoal extends CategorySuperEntity {

	@Id
	@GeneratedValue//(strategy=GenerationType.IDENTITY)
	private Long uid;
	private String code;
	@Column(length = 512)
	private String name;
	
	@Transient
	private Long categoryProgrammeID;

	@ManyToOne
	@JoinColumn(name="categoryPrograme_uid")
	@JsonBackReference
	private CategoryProgramme categoryProgramme;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="categoryProgramGoal")
	@JsonManagedReference
	private List<CategoryProgrammeGoalIndicator> categoryProgrameGoalIndicators;
	
	public CategoryProgrammeGoal(){}
	
	public CategoryProgrammeGoal(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
}

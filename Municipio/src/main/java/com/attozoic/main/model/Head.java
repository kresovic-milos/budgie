package com.attozoic.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="heads")
@Data
@EqualsAndHashCode(callSuper=true)
public class Head extends SuperEntity {
	
	private Long categoryID;

	private String code;
	private String name;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="head")
    private List<Activity> activities = new ArrayList<>();

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="head")
	private List<Project> projects = new ArrayList<>();
	
	public Head() {}
	
}

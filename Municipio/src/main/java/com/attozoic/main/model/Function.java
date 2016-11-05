package com.attozoic.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="functions")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "uid")
public class Function extends SuperEntity {
	
	private Long categoryID;
	
	private String code;
	private String name;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="function")
    private List<Activity> activities = new ArrayList<>();

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="function")
    private List<Project> projects = new ArrayList<>();
	
    public Function() {}
 
}

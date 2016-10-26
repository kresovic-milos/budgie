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
@Table(name="functions")
@Data
@EqualsAndHashCode(callSuper=true)
public class Function extends SuperEntity{
	
	private String code; // 010
	private String name; // Болест и инвалидност
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="function")
    private List<Activity> activities = new ArrayList<>();

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="function")
    private List<Project> projects = new ArrayList<>();
	
    public Function() {}

	public Function(String code, String name) {
		this.code = code;
		this.name = name;
	}
    
}

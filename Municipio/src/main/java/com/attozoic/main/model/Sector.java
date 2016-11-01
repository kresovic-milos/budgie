package com.attozoic.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="sectors")
@Data
@EqualsAndHashCode(callSuper=true)
public class Sector extends SuperEntity {

	private Long categoryID;
	
	@Column(length = 512)
	private String name;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="sector")
	@JsonManagedReference
    private List<Programme> programmes = new ArrayList<>(); 
	
	public Sector() {}
	
	public Sector(Long categoryID, String name) {
		this.categoryID = categoryID;
		this.name = name;
	}
	
}

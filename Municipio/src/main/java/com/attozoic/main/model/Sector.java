package com.attozoic.main.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="sectors")
@Data
@EqualsAndHashCode(callSuper=true)
public class Sector extends SuperEntity {

	private String name;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="sector")
	@JsonManagedReference
    private List<Programme> programmes; 
	
	public Sector() {}
	
	public Sector(String name) {
		this.name = name;
	}
	
}

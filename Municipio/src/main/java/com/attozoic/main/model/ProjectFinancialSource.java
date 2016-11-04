package com.attozoic.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="project_financial_sources")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid")
public class ProjectFinancialSource extends SuperEntity {
    
	private Long categoryID;
	
	private String code;
	private String name; // Приходи из буџета
	
	private double sourceBaseYear; // 2016
	private double sourceBaseYearPlus1; // 2017
	private double sourceBaseYearPlus2; // 2018
	private double sourceBaseYearPlus3; // 2019
	private double sumSources123;
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="financialSources")
	//@JsonIgnore
    private List<Project> project = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "projectFinancialSource_rebalances", joinColumns = @JoinColumn(name = "rebalance_uid"))
	private List<RebalanceOneField> rebalances = new ArrayList<>();
	
    public ProjectFinancialSource() {}
    
    public List<Double> listRebDouble(){
		List<Double> list = new ArrayList<>();
		for (RebalanceOneField rof : rebalances) {
			double sum = rof.getValue1() + rof.getValue2() + rof.getValue3() + rof.getValue4();
			list.add(sum);
		}
		return list;
	}
	
}

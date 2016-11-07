package com.attozoic.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
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
	
	@ManyToOne
	@JoinColumn(name="activity_uid")
    @NotFound(action=NotFoundAction.IGNORE)
    private Project project;
	
	@ElementCollection
	@CollectionTable(name = "projectFinancialSource_rebalances", joinColumns = @JoinColumn(name = "rebalance_uid"))
	@OrderColumn
	private List<RebalanceOneField> rebalances = new ArrayList<>();
	
    public ProjectFinancialSource() {}
    
    public List<Double> listRebDouble(){
		List<Double> list = new ArrayList<>();
		for (RebalanceOneField rof : rebalances) {
			double value = rof.getValue();
			list.add(value);
		}
		return list;
	}
	
}

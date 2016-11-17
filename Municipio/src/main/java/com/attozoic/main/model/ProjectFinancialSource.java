package com.attozoic.main.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="project_financial_sources")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=ProjectFinancialSource.class)
@JsonTypeName("projectFinancialSource")
public class ProjectFinancialSource extends SuperFinancialSource {
	
	private String type;
	
	private String code;
	
    public ProjectFinancialSource() {
    	this.type = "projectFinancialSource";    	
    	this.setQuarter1(0);
    	this.setQuarter2(0);
    	this.setQuarter3(0);
    	this.setQuarter4(0);
    	this.setAmount(this.sumQuarters());
    }
    
    public ProjectFinancialSource(String name, Double amount) {
    	this.setName(name);
    	this.setAmount(amount);
    }
    
    public ProjectFinancialSource sumProjectFinancialSourcesSameName(ProjectFinancialSource projectFinancialSource) {
    	ProjectFinancialSource sumProjectFinancialSource = new ProjectFinancialSource();
    	sumProjectFinancialSource.setName(this.getName());
    	sumProjectFinancialSource.setCode(this.getCode());
    	sumProjectFinancialSource.setYear(this.getYear());
    	sumProjectFinancialSource.setQuarter1(this.getQuarter1() + projectFinancialSource.getQuarter1());
    	sumProjectFinancialSource.setQuarter2(this.getQuarter2() + projectFinancialSource.getQuarter2());
    	sumProjectFinancialSource.setQuarter3(this.getQuarter3() + projectFinancialSource.getQuarter3());
    	sumProjectFinancialSource.setQuarter4(this.getQuarter4() + projectFinancialSource.getQuarter4());
    	sumProjectFinancialSource.setAmount(this.getAmount() + projectFinancialSource.getAmount());
    	this.setAmount(this.getAmount() + projectFinancialSource.getAmount());
    	return sumProjectFinancialSource;
    }
    
    private double sumQuarters() {
    	return this.getQuarter1() + this.getQuarter2() + this.getQuarter3() + this.getQuarter4();
    }
    
}

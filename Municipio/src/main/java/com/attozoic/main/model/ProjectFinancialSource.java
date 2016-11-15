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
	
	private String code;
	
    public ProjectFinancialSource() {
    	this.setAmount(0);
    }
    
    public ProjectFinancialSource(String name, double amount) {
    	this.setName(name);
    	this.setAmount(amount);
    }
    
}

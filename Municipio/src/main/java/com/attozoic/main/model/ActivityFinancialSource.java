package com.attozoic.main.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="activity_financial_sources")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=ActivityFinancialSource.class)
@JsonTypeName("activityFinancialSource")
public class ActivityFinancialSource extends SuperFinancialSource {
	
	private Long categoryID;

	private String code;
	private String name;
	
    public ActivityFinancialSource() {
    	this.setAmount(0);
    }

}

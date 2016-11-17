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
	
	private String type;
	private Long categoryID;
	private String code;
	
    public ActivityFinancialSource() {
    	this.type = "activityFinancialSource";
    	this.setQuarter1(0);
    	this.setQuarter2(0);
    	this.setQuarter3(0);
    	this.setQuarter4(0);
    	this.setAmount(this.sumQuarters());
    }
    
    public ActivityFinancialSource(String name, Double amount) {
    	this.setName(name);
    	this.setAmount(amount);
    }
    
    public ActivityFinancialSource sumActivityFinancialSourcesSameName(ActivityFinancialSource activityFinancialSource) {
    	ActivityFinancialSource sumActivityFinancialSource = new ActivityFinancialSource();
    	sumActivityFinancialSource.setName(this.getName());
    	sumActivityFinancialSource.setCode(this.getCode());
    	sumActivityFinancialSource.setYear(this.getYear());
    	sumActivityFinancialSource.setQuarter1(this.getQuarter1() + activityFinancialSource.getQuarter1());
    	sumActivityFinancialSource.setQuarter2(this.getQuarter2() + activityFinancialSource.getQuarter2());
    	sumActivityFinancialSource.setQuarter3(this.getQuarter3() + activityFinancialSource.getQuarter3());
    	sumActivityFinancialSource.setQuarter4(this.getQuarter4() + activityFinancialSource.getQuarter4());
    	sumActivityFinancialSource.setAmount(this.getAmount() + activityFinancialSource.getAmount());
    	this.setAmount(this.getAmount() + activityFinancialSource.getAmount());
    	return sumActivityFinancialSource;
    }
    
    private double sumQuarters() {
    	return this.getQuarter1() + this.getQuarter2() + this.getQuarter3() + this.getQuarter4();
    }

}

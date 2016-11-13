package com.attozoic.main.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.attozoic.main.model.balance.Balance;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({  
	@JsonSubTypes.Type(value = ActivityFinancialSource.class, name = "activityFinancialSource"),
	@JsonSubTypes.Type(value = ProjectFinancialSource.class, name = "projectFinancialSource")
})
@Data
@EqualsAndHashCode(callSuper=true)
public abstract class SuperFinancialSource extends SuperEntity {

	private double amount;

	@ManyToOne
	@JoinColumn(name = "balance_q1_id")
	@NotFound(action=NotFoundAction.IGNORE)
	@JsonIgnoreProperties({"balanceType", "year", "quarter1", "quarter2", "quarter3", "quarter4"})
	private Balance balance_q1;

	@ManyToOne
	@JoinColumn(name = "balance_q2_id")
	@NotFound(action=NotFoundAction.IGNORE)
	@JsonIgnoreProperties({"balanceType", "year", "quarter1", "quarter2", "quarter3", "quarter4"})
	private Balance balance_q2;
	
	@ManyToOne
	@JoinColumn(name = "balance_q3_id")
	@NotFound(action=NotFoundAction.IGNORE)
	@JsonIgnoreProperties({"balanceType", "year", "quarter1", "quarter2", "quarter3", "quarter4"})
	private Balance balance_q3;
	
	@ManyToOne
	@JoinColumn(name = "balance_q4_id")
	@NotFound(action=NotFoundAction.IGNORE)
	@JsonIgnoreProperties({"balanceType", "year", "quarter1", "quarter2", "quarter3", "quarter4"})
	private Balance balance_q4;

}

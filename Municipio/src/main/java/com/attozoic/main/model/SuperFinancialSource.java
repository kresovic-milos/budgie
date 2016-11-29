package com.attozoic.main.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.attozoic.main.model.balance.Balance;
import com.attozoic.main.model.dto.DtoFinancialSource;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
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

	private String name;
	private double year;
	
	private double quarter1;
	private double quarter2;
	private double quarter3;
	private double quarter4;
	
	private double amount;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "balance_id")
	@NotFound(action=NotFoundAction.IGNORE)
	//@JsonIgnoreProperties({"balanceType", "quarter1", "quarter2", "quarter3", "quarter4"})
	@JsonIdentityReference(alwaysAsId = true)
	private Balance balance;
	
	public void generateFinancialSourceAmount() {
		this.setAmount(this.getQuarter1() + this.getQuarter2() + this.getQuarter3() + this.getQuarter4());
	}
	
    public DtoFinancialSource generateDtoFinancialSource() {
    	if (this.getActiveState() == ActiveState.ACTIVE) {
    		return new DtoFinancialSource(this.getName(), this.getYear(), this.getAmount());
    	}
    	else return null;
    }
	
}

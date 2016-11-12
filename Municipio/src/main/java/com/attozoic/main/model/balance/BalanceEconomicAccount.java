package com.attozoic.main.model.balance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.ProjectFinancialSource;
import com.attozoic.main.model.SuperEntity;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT, property = "type")  
@JsonSubTypes({  
	@JsonSubTypes.Type(value = BalanceNumeric.class, name = "balanceNumeric"),
	@JsonSubTypes.Type(value = BalanceWithQuarters.class, name = "balanceWithQuarters")
    })
@Data
@EqualsAndHashCode(callSuper=true)
public abstract class BalanceEconomicAccount extends SuperEntity{
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="balanceContainer_uid")
	@NotFound(action=NotFoundAction.IGNORE)
	private BalanceContainer balanceContainer;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="balanceEconomicAccount")
	private List<ActivityFinancialSource> activityFinancialSources = new ArrayList<>();

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="balanceEconomicAccount")
	private List<ProjectFinancialSource> projectFinancialSources = new ArrayList<>();
	
	public abstract void sumBalances(BalanceEconomicAccount balance);
}

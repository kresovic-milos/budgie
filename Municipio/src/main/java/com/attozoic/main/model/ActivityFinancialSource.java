package com.attozoic.main.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.attozoic.main.model.balance.BalanceEconomicAccount;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="activity_financial_sources")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=ActivityFinancialSource.class)
public class ActivityFinancialSource extends SuperEntity {
	
	private Long categoryID;

	private String code;
	private String name;

	@ManyToOne
	@JoinColumn(name = "balanceEconomicAccount")
	@NotFound(action=NotFoundAction.IGNORE)
	private BalanceEconomicAccount balanceEconomicAccount;
	
    public ActivityFinancialSource() {}

}

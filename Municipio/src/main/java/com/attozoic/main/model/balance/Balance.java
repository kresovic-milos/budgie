package com.attozoic.main.model.balance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.attozoic.main.model.SuperEconomicAccount;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.model.SuperFinancialSource;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "balance")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=Balance.class)
public class Balance extends SuperEntity {
	
	private BalanceType balanceType;
	private double year;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="economicAccount_uid")
	@NotFound(action=NotFoundAction.IGNORE)
	@JsonIgnoreProperties({"balances", "activity", "project", "categoryID", "code", "categoryName", "name", "poz", "sumExpenses123Budget", "sumExpenses123Others"})
	private SuperEconomicAccount superEconomicAccount;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="balance_q1")
	private List<SuperFinancialSource> quarter1 = new ArrayList<>();
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="balance_q2")
	private List<SuperFinancialSource> quarter2 = new ArrayList<>();
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="balance_q3")
	private List<SuperFinancialSource> quarter3 = new ArrayList<>();
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="balance_q4")
	private List<SuperFinancialSource> quarter4 = new ArrayList<>();
	
	public Balance() {}

	public Balance(BalanceType balanceType, double year, SuperEconomicAccount superEconomicAccount) {
		this.balanceType = balanceType;
		this.year = year;
		this.superEconomicAccount = superEconomicAccount;
	}
	
}

package com.attozoic.main.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.attozoic.categories.model.CategoryEconomicAccount;

import lombok.Data;

@Entity
@Table(name="economic_accounts")
@Data
public class EconomicAccount {

	@Id
	@GeneratedValue
	private Long uid;
	
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
    @PrimaryKeyJoinColumn
	private CategoryEconomicAccount categoryEconomicAccount;
    
	private String poz;
	
	private long expenseBaseYearBudget; // 2016
	private long expenseBaseYearOthers; // 2016
	private long expenseBaseYearPlus1Budget; // 2017
	private long expenseBaseYearPlus1Others; // 2017
	private long expenseBaseYearPlus1Rebalance1Budget;
	private long expenseBaseYearPlus1Rebalance1Others;
	private long expenseBaseYearPlus1Rebalance2Budget;
	private long expenseBaseYearPlus1Rebalance2Others;
	private long expenseBaseYearPlus1Rebalance3Budget;
	private long expenseBaseYearPlus1Rebalance3Others;
	private long expenseBaseYearPlus1Rebalance4Budget;
	private long expenseBaseYearPlus1Rebalance4Others;
	private long expenseBaseBudget; // 2018
	private long expenseBaseOthers; // 2018
	private long expenseBaseYearPlus3Budget; // 2019
	private long expenseBaseYearPlus3Others; // 2019
	private long sumExpenses123Budget;
	private long sumExpenses123Others;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "create_date")
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "update_date")
	private Date updateDate;
	
	public EconomicAccount() {}

	public EconomicAccount(CategoryEconomicAccount categoryEconomicAccount, String poz, long expenseBaseYearBudget,
			long expenseBaseYearOthers, long expenseBaseYearPlus1Budget, long expenseBaseYearPlus1Others,
			long expenseBaseYearPlus1Rebalance1Budget, long expenseBaseYearPlus1Rebalance1Others,
			long expenseBaseYearPlus1Rebalance2Budget, long expenseBaseYearPlus1Rebalance2Others,
			long expenseBaseYearPlus1Rebalance3Budget, long expenseBaseYearPlus1Rebalance3Others,
			long expenseBaseYearPlus1Rebalance4Budget, long expenseBaseYearPlus1Rebalance4Others,
			long expenseBaseBudget, long expenseBaseOthers, long expenseBaseYearPlus3Budget,
			long expenseBaseYearPlus3Others, long sumExpenses123Budget, long sumExpenses123Others) {
		this.categoryEconomicAccount = categoryEconomicAccount;
		this.poz = poz;
		this.expenseBaseYearBudget = expenseBaseYearBudget;
		this.expenseBaseYearOthers = expenseBaseYearOthers;
		this.expenseBaseYearPlus1Budget = expenseBaseYearPlus1Budget;
		this.expenseBaseYearPlus1Others = expenseBaseYearPlus1Others;
		this.expenseBaseYearPlus1Rebalance1Budget = expenseBaseYearPlus1Rebalance1Budget;
		this.expenseBaseYearPlus1Rebalance1Others = expenseBaseYearPlus1Rebalance1Others;
		this.expenseBaseYearPlus1Rebalance2Budget = expenseBaseYearPlus1Rebalance2Budget;
		this.expenseBaseYearPlus1Rebalance2Others = expenseBaseYearPlus1Rebalance2Others;
		this.expenseBaseYearPlus1Rebalance3Budget = expenseBaseYearPlus1Rebalance3Budget;
		this.expenseBaseYearPlus1Rebalance3Others = expenseBaseYearPlus1Rebalance3Others;
		this.expenseBaseYearPlus1Rebalance4Budget = expenseBaseYearPlus1Rebalance4Budget;
		this.expenseBaseYearPlus1Rebalance4Others = expenseBaseYearPlus1Rebalance4Others;
		this.expenseBaseBudget = expenseBaseBudget;
		this.expenseBaseOthers = expenseBaseOthers;
		this.expenseBaseYearPlus3Budget = expenseBaseYearPlus3Budget;
		this.expenseBaseYearPlus3Others = expenseBaseYearPlus3Others;
		this.sumExpenses123Budget = sumExpenses123Budget;
		this.sumExpenses123Others = sumExpenses123Others;
	}
	
	
	
}

package com.attozoic.main.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.attozoic.categories.model.CategoryFinancialSource;

import lombok.Data;

@Entity
@Table(name="financial_source")
@Data
public class FinancialSource {

	@Id
	@GeneratedValue
	private Long uid;
	
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
    @PrimaryKeyJoinColumn
	private CategoryFinancialSource categoryFinancialSource;
	
	private long sourceBaseYear; // 2016
	private long sourceBaseYearPlus1; // 2017
	private long sourceBaseYearPlus1Rebalance1; 
	private long sourceBaseYearPlus1Rebalance2;
	private long sourceBaseYearPlus1Rebalance3;
	private long sourceBaseYearPlus1Rebalance4;
	private long sourceBaseYearPlus2; // 2018
	private long sourceBaseYearPlus3; // 2019
	private long sumSources123;
    
	@CreationTimestamp
	@Column(name = "create_date")
	private Date createDate;

	@UpdateTimestamp
	@Column(name = "update_date")
	private Date updateDate;
	
    public FinancialSource() {}

	public FinancialSource(CategoryFinancialSource categoryFinancialSource, long sourceBaseYear,
			long sourceBaseYearPlus1, long sourceBaseYearPlus1Rebalance1, long sourceBaseYearPlus1Rebalance2,
			long sourceBaseYearPlus1Rebalance3, long sourceBaseYearPlus1Rebalance4, long sourceBaseYearPlus2,
			long sourceBaseYearPlus3, long sumSources123) {
		this.categoryFinancialSource = categoryFinancialSource;
		this.sourceBaseYear = sourceBaseYear;
		this.sourceBaseYearPlus1 = sourceBaseYearPlus1;
		this.sourceBaseYearPlus1Rebalance1 = sourceBaseYearPlus1Rebalance1;
		this.sourceBaseYearPlus1Rebalance2 = sourceBaseYearPlus1Rebalance2;
		this.sourceBaseYearPlus1Rebalance3 = sourceBaseYearPlus1Rebalance3;
		this.sourceBaseYearPlus1Rebalance4 = sourceBaseYearPlus1Rebalance4;
		this.sourceBaseYearPlus2 = sourceBaseYearPlus2;
		this.sourceBaseYearPlus3 = sourceBaseYearPlus3;
		this.sumSources123 = sumSources123;
	}
    
}

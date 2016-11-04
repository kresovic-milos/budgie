package com.attozoic.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="activity_financial_sources")
@Data
@EqualsAndHashCode(callSuper=true)
public class ActivityFinancialSource extends SuperEntity {
	
	private Long categoryID;

	private String code; // 01
	private String name; // Приходи из буџета

    @ManyToMany(cascade=CascadeType.ALL, mappedBy="activityFinancialSources")
    @JsonIgnore
    private List<Activity> activities = new ArrayList<>();
    
	private double sourceBaseYear; // 2016
	private double sourceBaseYearPlus1; // 2017
	private double sourceBaseYearPlus2; // 2018
	private double sourceBaseYearPlus3; // 2019
	private double sumSources123;
	
	@ElementCollection
	@CollectionTable(name = "activityFinancialSource_rebalances", joinColumns = @JoinColumn(name = "rebalance_uid"))
	private List<RebalanceOneField> rebalances = new ArrayList<>();
	
    public ActivityFinancialSource() {}

	public ActivityFinancialSource(Long categoryID, String code, String name, long sourceBaseYear, long sourceBaseYearPlus1,
			long sourceBaseYearPlus2, long sourceBaseYearPlus3, long sumSources123) {
		this.categoryID = categoryID;
		this.code = code;
		this.name = name;
		this.sourceBaseYear = sourceBaseYear;
		this.sourceBaseYearPlus1 = sourceBaseYearPlus1;
		this.sourceBaseYearPlus2 = sourceBaseYearPlus2;
		this.sourceBaseYearPlus3 = sourceBaseYearPlus3;
		this.sumSources123 = sumSources123;
	}
	
	public List<Double> listRebDouble(){
		List<Double> list = new ArrayList<>();
		for (RebalanceOneField rof : rebalances) {
			double sum = rof.getValue1() + rof.getValue2() + rof.getValue3() + rof.getValue4();
			list.add(sum);
		}
		return list;
	}

}

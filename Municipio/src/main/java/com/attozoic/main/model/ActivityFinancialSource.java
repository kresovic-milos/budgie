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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="activity_financial_sources")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "uid")
public class ActivityFinancialSource extends SuperEntity {
	
	private transient RebalancesCount rc;
	
	private Long categoryID;

	private String code;
	private String name;

    @ManyToMany(cascade=CascadeType.ALL, mappedBy="activityFinancialSources")
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
	
	public List<Double> listRebDouble(){
		List<Double> list = new ArrayList<>();
		for (RebalanceOneField rof : rebalances) {
			double sum = rof.getValue1() + rof.getValue2() + rof.getValue3() + rof.getValue4();
			list.add(sum);
		}
		return list;
	}

}

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
@Table(name="programme_financial_source")
@Data
@EqualsAndHashCode(callSuper=true)
public class ProgrammeFinancialSource extends SuperEntity {
	
	private Long categoryID;
	
	private String code;
	private String name;

    @ManyToMany(cascade=CascadeType.ALL, mappedBy="programmeFinancialSources")
    @JsonIgnore
    private List<Programme> programmes = new ArrayList<>();
    
	private double sourceBaseYear; // 2016
	private double sourceBaseYearPlus1; // 2017
	private double sourceBaseYearPlus2; // 2018
	private double sourceBaseYearPlus3; // 2019
	private double sumSources123;
	
	@ElementCollection
	@CollectionTable(name = "programme_financial_source_rebalances", joinColumns = @JoinColumn(name = "rebalance_uid"))
	private List<RebalanceOneField> rebalances = new ArrayList<>();
	
    public ProgrammeFinancialSource() {
    }
  
}

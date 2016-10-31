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
	
	private String code; // 01
	private String name; // Приходи из буџета

    @ManyToMany(cascade=CascadeType.ALL, mappedBy="programmeFinancialSources")
    @JsonIgnore
    private List<Programme> programmes = new ArrayList<>();
    
	private long sourceBaseYear; // 2016
	private long sourceBaseYearPlus1; // 2017
	private long sourceBaseYearPlus2; // 2018
	private long sourceBaseYearPlus3; // 2019
	private long sumSources123;
	
	@ElementCollection
	@CollectionTable(name = "programme_financial_source_rebalances", joinColumns = @JoinColumn(name = "rebalance_uid"))
	private List<RebalanceOneField> rebalances = new ArrayList<>();
	
    public ProgrammeFinancialSource() {
    }
    
    
    
}

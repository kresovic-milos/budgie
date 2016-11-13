package com.attozoic.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.attozoic.main.model.balance.BalanceText;
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
	@JsonSubTypes.Type(value = ProgrammeGoalIndicator.class, name = "programmeGoalIndicator"),
	@JsonSubTypes.Type(value = ActivityGoalIndicator.class, name = "activityGoalIndicator"),
	@JsonSubTypes.Type(value = ProjectGoalIndicator.class, name = "projectGoalIndicator")
})
@Data
@EqualsAndHashCode(callSuper=true)
public abstract class SuperGoalIndicator extends SuperEntity {

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="superGoalIndicator")
	List<BalanceText> balancesText = new ArrayList<>();
	
}

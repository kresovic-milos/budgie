package com.attozoic.main.model;

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

import com.attozoic.main.model.balance.BalanceText;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="project_goal_indicators")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=ProjectGoalIndicator.class)
public class ProjectGoalIndicator extends SuperEntity {

	private String name;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="projectGoalIndicator")
	List<BalanceText> balancesText = new ArrayList<>();

    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="projectGoal_uid")
    @NotFound(action=NotFoundAction.IGNORE)
    private ProjectGoal projectGoal;
	
	public ProjectGoalIndicator() {}
	
    public void addRebalance() {
    	try {
    		this.balancesText.add(2, new BalanceText());
    	} catch(IndexOutOfBoundsException ex) {}
    }
    
    public void removeRebalance() {
    	this.balancesText.remove(3);
    }
	
}

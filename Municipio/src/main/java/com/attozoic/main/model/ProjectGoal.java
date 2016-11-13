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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="project_goals")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=ProjectGoal.class)
public class ProjectGoal extends SuperEntity {
	
	private String name;
	
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_uid")
    @NotFound(action=NotFoundAction.IGNORE)
    @JsonIgnoreProperties({"code", "name", "purpose", "rudiment", "description", "anex", "responsibleAuthority", "categoryFunctionID", "functionCode", "function", "categoryHeadID", "headCode", "head", "categoryAuthorityID", "authorityCode", "authority", "authorityJbbk", "programme", "projectGoals", "projectEconomicAccounts"})
    private Project project;
    
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="projectGoal")
    private List<ProjectGoalIndicator> projectGoalIndicators = new ArrayList<>();
	
    public ProjectGoal() {}

}

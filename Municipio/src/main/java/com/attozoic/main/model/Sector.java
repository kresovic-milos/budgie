package com.attozoic.main.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.attozoic.categories.model.CategorySector;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name="sectors")
@Data
public class Sector {

	@Id
	@GeneratedValue
	private Long uid;
	
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
    // @JoinColumn(name="USER_ID", nullable=false)
    @PrimaryKeyJoinColumn
	private CategorySector categorySector;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="sector")
	@JsonManagedReference
    private List<Programme> programmes; 
    
	@CreationTimestamp
	@Column(name = "create_date")
	private Date createDate;

	@UpdateTimestamp
	@Column(name = "update_date")
	private Date updateDate;
	
	public Sector() {}
	
	public Sector(CategorySector categorySector) {
		this.categorySector = categorySector;
	}
	
//	public String toString() {
//		return uid;
//	}
	
}

package com.attozoic.main.dao;

import java.util.List;

import javax.persistence.AttributeOverride;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Programme;
import com.attozoic.main.repositories.RepositoryProgramme;

@Repository
public class DaoProgramme {
	@Autowired
		private SessionFactory sessionF;
	
	@Autowired
	private RepositoryProgramme repoProgramme;
	
	public Page<Programme> findAll() {	
		try{
			Session sesion = sessionF.openSession();
			Criteria nekiCrit = sesion.createCriteria(Programme.class);
			// nekiCrit.add(Restrictions.eq("name", "pera"))
			List<Programme> asdf = nekiCrit.list();
			System.out.println("Total: " + asdf.size());
		}catch (Exception e) {
			System.out.println("Ex: "  + e.getMessage());
			e.printStackTrace();
		}

		Page<Programme> page = new PageImpl<>(repoProgramme.findAll());
		return page;
	}
	
	public Programme save(Programme programme) {
		return repoProgramme.save(programme);
	}
	
}

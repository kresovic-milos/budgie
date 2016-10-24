package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActiveState;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositorySector;

@Repository
public abstract class DaoEntity {
//	@Autowired
//		private SessionFactory sessionFactory;
	
	public abstract RepositoryEntity getRepoEntity();

	public Page<SuperEntity> findAll() {	
//		try{
//			Session sesion = sessionF.openSession();
//			Criteria nekiCrit = sesion.createCriteria(Programme.class);
//			// nekiCrit.add(Restrictions.eq("name", "pera"))
//			List<Programme> asdf = nekiCrit.list();
//			System.out.println("Total: " + asdf.size());
//		}catch (Exception e) {
//			System.out.println("Ex: "  + e.getMessage());
//			e.printStackTrace();
//		}

		Page<SuperEntity> page = new PageImpl<>(getRepoEntity().findAll());
		return page;
	}
	
	public SuperEntity findOne(Long uid) {
		return getRepoEntity().findOne(uid);
	}
	
	public SuperEntity save(SuperEntity superEntity) {
		return getRepoEntity().save(superEntity);
	}
	
	public SuperEntity update(SuperEntity superEntity) {
		return getRepoEntity().save(superEntity);
	}
	
	public void delete(Long uid) {
		getRepoEntity().delete(uid);
	}
	
	public void archive(Long uid) {
		//sessionFactory.openSession().create
		SuperEntity superEntity = getRepoEntity().findOne(uid);
		superEntity.setActiveState(ActiveState.ARCHIVED);
		getRepoEntity().save(superEntity);
	}
	
	public void unarchive(Long uid) {
		SuperEntity superEntity = getRepoEntity().findOne(uid);
		superEntity.setActiveState(ActiveState.ACTIVE);
		getRepoEntity().save(superEntity);
	}
	
}

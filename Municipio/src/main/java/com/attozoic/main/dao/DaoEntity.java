package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActiveState;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.repositories.RepositoryEntity;

@Repository
public class DaoEntity {
//	@Autowired
//		private SessionFactory sessionFactory;
	
	@Autowired
	private RepositoryEntity repoEntity;
	
	public RepositoryEntity getRepoEntity() {
		return repoEntity;
	}

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

		Page<SuperEntity> page = new PageImpl<>(repoEntity.findAll());
		return page;
	}
	
	public SuperEntity findOne(Long uid) {
		return repoEntity.findOne(uid);
	}
	
	public SuperEntity save(SuperEntity superEntity) {
		return repoEntity.save(superEntity);
	}
	
	public SuperEntity update(SuperEntity superEntity) {
		return repoEntity.save(superEntity);
	}
	
	public void delete(Long uid) {
		repoEntity.delete(uid);
	}
	
	public void archive(Long uid) {
		//sessionFactory.openSession().create
		SuperEntity superEntity = repoEntity.findOne(uid);
		superEntity.setActiveState(ActiveState.ARCHIVED);
		repoEntity.save(superEntity);
	}
	
	public void unarchive(Long uid) {
		SuperEntity superEntity = repoEntity.findOne(uid);
		superEntity.setActiveState(ActiveState.ACTIVE);
		repoEntity.save(superEntity);
	}
	
}

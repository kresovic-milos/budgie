package com.attozoic.main.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActiveState;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.repositories.RepositoryEntity;

@Repository
public abstract class DaoEntity {
	
	// Getter za konkretni Repo svakog pojedinacnog Dao objekta
	@SuppressWarnings("rawtypes")
	public abstract RepositoryEntity getRepoEntity();

	// Vraca sve unete objekte zeljenog tipa (SuperEntity)
	@SuppressWarnings("unchecked")
	public Page<SuperEntity> findAll() {
		Page<SuperEntity> page = new PageImpl<>(getRepoEntity().findAll());
		return page;	
	}
	
	// Vraca jedan, trazen po UID-u
	public SuperEntity findOne(Long uid) {
		return getRepoEntity().findOne(uid);
	}
	
	// Cuva objekat
	@SuppressWarnings("unchecked")
	public SuperEntity save(SuperEntity superEntity) {
		return getRepoEntity().save(superEntity);
	}
	
	@SuppressWarnings("unchecked")
	public SuperEntity update(SuperEntity superEntity) {
		return getRepoEntity().save(superEntity);
	}
	
	public void delete(Long uid) {
		getRepoEntity().delete(uid);
	}
	
	@SuppressWarnings("unchecked")
	public void archive(Long uid) {
		//sessionFactory.openSession().create
		SuperEntity superEntity = getRepoEntity().findOne(uid);
		superEntity.setActiveState(ActiveState.ARCHIVED);
		getRepoEntity().save(superEntity);
	}
	
	@SuppressWarnings("unchecked")
	public void unarchive(Long uid) {
		SuperEntity superEntity = getRepoEntity().findOne(uid);
		superEntity.setActiveState(ActiveState.ACTIVE);
		getRepoEntity().save(superEntity);
	}
	
}

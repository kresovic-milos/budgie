package com.attozoic.categories.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategorySuperEntity;
import com.attozoic.categories.repositories.RepositoryCategoryEntity;
import com.attozoic.main.model.ActiveState;

@Repository
public abstract class DaoCategoryEntity {

	@SuppressWarnings("rawtypes")
	public abstract RepositoryCategoryEntity getCategoryRepoEntity();
	
	// Vraca Listu ACTIVE CategorySuperEntity
	@SuppressWarnings("unchecked")
	public Page<CategorySuperEntity> findActive() {
		Page<CategorySuperEntity> page = new PageImpl<>(getCategoryRepoEntity().findByActiveState(ActiveState.ACTIVE));
		return page;
	}
	
	// Vraca Listu ARCHIVED CategorySuperEntity
	@SuppressWarnings("unchecked")
	public Page<CategorySuperEntity> findArchived() {
		Page<CategorySuperEntity> page = new PageImpl<>(getCategoryRepoEntity().findByActiveState(ActiveState.ARCHIVED));
		return page;
	}
	
	// Vraca sve unete objekte zeljenog tipa (CategorySuperEntity)
	@SuppressWarnings("unchecked")
	public Page<CategorySuperEntity> findAll() {
		Page<CategorySuperEntity> page = new PageImpl<>(getCategoryRepoEntity().findAll());
		return page;
	}
	
	// Vraca jedan (CategorySuperEntity), trazen po UID-u
	public CategorySuperEntity findOne(Long uid) {
		return getCategoryRepoEntity().findOne(uid);
	}
	
//	// Cuva (CategorySuperEntity) objekat i setuje ActiveState na Active ako je nov
//	@SuppressWarnings("unchecked")
//	public CategorySuperEntity save(CategorySuperEntity categorySuperEntity) {
//		try {
//			if (categorySuperEntity.getUid()==null||!getCategoryRepoEntity().exists(categorySuperEntity.getUid())) {
//				categorySuperEntity.setActiveState(ActiveState.ACTIVE);
//				System.out.println("USAO SAM");
//			} 
//		} catch (Exception ex) {
//			System.out.println("UFACEN");
//		}
//		System.out.println(categorySuperEntity.getActiveState());
//		return getCategoryRepoEntity().save(categorySuperEntity);
//	}
	
	// Cuva (CategorySuperEntity) objekat i setuje ActiveState na Active ako je nov
	@SuppressWarnings("unchecked")
	public CategorySuperEntity save(CategorySuperEntity categorySuperEntity) {
		return getCategoryRepoEntity().save(categorySuperEntity);
	}
	
	@SuppressWarnings("unchecked")
	public CategorySuperEntity update(CategorySuperEntity categorySuperEntity) {
		return getCategoryRepoEntity().save(categorySuperEntity);
	}
	
	public void delete(Long uid) {
		getCategoryRepoEntity().delete(uid);
	}
	
	@SuppressWarnings("unchecked")
	public void archive(Long uid) {
		CategorySuperEntity categorySuperEntity = getCategoryRepoEntity().findOne(uid);
		categorySuperEntity.setActiveState(ActiveState.ARCHIVED);
		getCategoryRepoEntity().save(categorySuperEntity);
	}
	
	@SuppressWarnings("unchecked")
	public void unarchive(Long uid) {
		CategorySuperEntity categorySuperEntity = getCategoryRepoEntity().findOne(uid);
		categorySuperEntity.setActiveState(ActiveState.ACTIVE);
		getCategoryRepoEntity().save(categorySuperEntity);
	}
	
}

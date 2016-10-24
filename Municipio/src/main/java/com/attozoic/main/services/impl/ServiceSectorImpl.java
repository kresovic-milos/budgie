package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.dao.DaoSector;
import com.attozoic.main.model.Programme;
import com.attozoic.main.services.ServiceSector;

@Service
public class ServiceSectorImpl extends ServiceEntityImpl implements ServiceSector {

	@Autowired
	private DaoSector daoEntity;
	
	@Override
	public DaoEntity getDaoEntity() {
		return daoEntity;
	}
	
	@Override
	public Programme addProgramme(Long uid, Programme programme) {
		return ((DaoSector) getDaoEntity()).addProgramme(uid, programme);
	}	
}
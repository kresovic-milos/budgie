package com.attozoic.main.services;

import com.attozoic.main.model.Programme;

public interface ServiceSector extends ServiceEntity {
	
	Programme addProgramme(Long uid, Programme programme);
}

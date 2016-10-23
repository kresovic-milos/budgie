package com.attozoic;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MunicipioApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MunicipioApplication.class, args);
	}
	
	@Bean  
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){  
	    return hemf.getSessionFactory();  
	}
	
	@Bean  
	public SessionFactory sessionFactory(org.hibernate.ejb.HibernateEntityManagerFactory hemf){  
	    return hemf.getSessionFactory();  
	}
}

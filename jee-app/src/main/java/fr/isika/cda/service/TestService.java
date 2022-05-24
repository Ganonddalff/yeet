package fr.isika.cda.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.entities.TestEntity;

@Stateless
public class TestService {

	@PersistenceContext(name = "jee")
	private EntityManager manager;
	
	public void create(TestEntity entity) {
		manager.persist(entity);
	}
	
}

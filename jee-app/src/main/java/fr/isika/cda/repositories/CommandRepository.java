package fr.isika.cda.repositories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.model.entities.Command;

@Stateless
public class CommandRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public CommandRepository() {
		
	}
	
	public Command create(Command cmd) {
		entityManager.persist(cmd);
        entityManager.flush();
        entityManager.clear();
        
        return cmd;
	}

}

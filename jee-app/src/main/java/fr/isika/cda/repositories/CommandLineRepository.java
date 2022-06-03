package fr.isika.cda.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.model.entities.CommandLine;

public class CommandLineRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public CommandLineRepository() {
		
	}
	
	public CommandLine create(CommandLine line) {
		entityManager.persist(line);
        entityManager.flush();
        entityManager.clear();
        
        return line;
	}


}

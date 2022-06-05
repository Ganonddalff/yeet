package fr.isika.cda.repositories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.model.entities.Command;
import fr.isika.cda.model.entities.FundRaising;

import java.util.List;
import java.util.Optional;

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

	public List<Command> findAllCommands(){
		return this.entityManager.createQuery("SELECT c FROM Command c", Command.class).getResultList();
	}

    public double totalSales() {
		Optional<Double> totalSum = this.findAllCommands().stream().map(Command::getTotalAmount).reduce(Double::sum);
		if(totalSum.isPresent()) return totalSum.get();
		return 0;
    }
}

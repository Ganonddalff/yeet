package fr.isika.cda.services;

import javax.inject.Inject;

import fr.isika.cda.repositories.CommandRepository;

public class CommandService {
	
	@Inject
	CommandRepository commandRepository;
	
	public CommandService() {
		
	}


    public double totalSales() {
		return commandRepository.totalSales();
    }
}

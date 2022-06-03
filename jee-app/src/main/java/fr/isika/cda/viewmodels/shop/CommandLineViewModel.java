package fr.isika.cda.viewmodels.shop;

import fr.isika.cda.model.entities.CommandLine;
import fr.isika.cda.model.factories.implementation.CommandLineFactoryImpl;

public class CommandLineViewModel {
	
	private CommandLine commandLineViewModel;
	
	public CommandLineViewModel() {
        this.commandLineViewModel = CommandLineFactoryImpl.getInstance().getCommandLine();
	}
	
	

}

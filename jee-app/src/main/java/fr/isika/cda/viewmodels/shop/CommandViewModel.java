package fr.isika.cda.viewmodels.shop;

import fr.isika.cda.model.entities.Command;
import fr.isika.cda.model.factories.implementation.CommandFactoryImpl;


public class CommandViewModel {
	
private Command commandViewModel;
	
	public CommandViewModel() {
        this.commandViewModel = CommandFactoryImpl.getInstance().getCommand();
	}

}

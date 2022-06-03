package fr.isika.cda.model.factories.implementation;

import fr.isika.cda.model.entities.CommandLine;
import fr.isika.cda.model.factories.interfaces.CommandLineFactory;

public class CommandLineFactoryImpl implements CommandLineFactory{
	
	private static CommandLineFactoryImpl instance = null;

	private CommandLineFactoryImpl(){}

	public static synchronized CommandLineFactoryImpl getInstance() {
		if (instance ==	null) {
			instance = new CommandLineFactoryImpl();
		}
		return instance;
	}

	@Override
	public Object clone() throws CloneNotSupportedException	{
		throw new CloneNotSupportedException();
	}


	@Override
	public CommandLine getCommandLine() {

		return new CommandLine();
	}

}

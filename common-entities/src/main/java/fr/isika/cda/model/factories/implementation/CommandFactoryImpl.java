package fr.isika.cda.model.factories.implementation;

import fr.isika.cda.model.entities.Command;
import fr.isika.cda.model.factories.interfaces.CommandFactory;

public class CommandFactoryImpl implements CommandFactory{

	private static CommandFactoryImpl instance = null;

	private CommandFactoryImpl(){}

	public static synchronized CommandFactoryImpl getInstance() {
		if (instance ==	null) {
			instance = new CommandFactoryImpl();
		}
		return instance;
	}

	@Override
	public Object clone() throws CloneNotSupportedException	{
		throw new CloneNotSupportedException();
	}


	@Override
	public Command getCommand() {

		return new Command();
	}

}

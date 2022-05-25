package fr.isika.cda.model.factories.implementation;

import fr.isika.cda.model.entities.Address;
import fr.isika.cda.model.factories.interfaces.AddressFactory;

public class AddressFactoryImpl implements AddressFactory {
    private static AddressFactoryImpl instance = null;

    private AddressFactoryImpl(){}

    public static synchronized AddressFactoryImpl getInstance() {
        if (instance ==	null) {
            instance = new AddressFactoryImpl();
        }
        return instance;
    }

    @Override
    public Object clone() throws CloneNotSupportedException	{
        throw new CloneNotSupportedException();
    }

    @Override
    public Address getAddress() {
        return new Address();
    }
}

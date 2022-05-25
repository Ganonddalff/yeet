package fr.isika.cda.model.factories.implementation;

import fr.isika.cda.model.entities.Person;
import fr.isika.cda.model.factories.interfaces.PersonFactory;

public class PersonFactoryImpl implements PersonFactory {
    private static PersonFactoryImpl instance = null;

    private PersonFactoryImpl(){}

    public static synchronized PersonFactoryImpl getInstance() {
        if (instance ==	null) {
            instance = new PersonFactoryImpl();
        }
        return instance;
    }

    @Override
    public Object clone() throws CloneNotSupportedException	{
        throw new CloneNotSupportedException();
    }

    @Override
    public Person getPerson() {
        return new Person();
    }
}

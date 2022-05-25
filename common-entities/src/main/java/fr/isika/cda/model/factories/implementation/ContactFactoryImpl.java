package fr.isika.cda.model.factories.implementation;

import fr.isika.cda.model.entities.Contact;
import fr.isika.cda.model.factories.interfaces.ContactFactory;

public class ContactFactoryImpl implements ContactFactory {
    private static ContactFactoryImpl instance = null;

    private ContactFactoryImpl(){}

    public static synchronized ContactFactoryImpl getInstance() {
        if (instance ==	null) {
            instance = new ContactFactoryImpl();
        }
        return instance;
    }

    @Override
    public Object clone() throws CloneNotSupportedException	{
        throw new CloneNotSupportedException();
    }

    @Override
    public Contact getContact() {
        return new Contact();
    }
}

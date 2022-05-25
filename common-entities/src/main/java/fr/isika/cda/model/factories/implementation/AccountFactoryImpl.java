package fr.isika.cda.model.factories.implementation;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.model.enumeration.AccountCategory;
import fr.isika.cda.model.factories.interfaces.AccountFactory;

public class AccountFactoryImpl implements AccountFactory {
    private static AccountFactoryImpl instance = null;

    private AccountFactoryImpl(){}

    public static synchronized AccountFactoryImpl getInstance() {
        if (instance ==	null) {
            instance = new AccountFactoryImpl();
        }
        return instance;
    }

    @Override
    public Object clone() throws CloneNotSupportedException	{
        throw new CloneNotSupportedException();
    }

    @Override
    public Account getAccount() {
        return new Account();
    }
}

package fr.isika.cda.model.factories.implementation;

import fr.isika.cda.model.entities.CreditCard;
import fr.isika.cda.model.entities.FundRaising;
import fr.isika.cda.model.factories.interfaces.CreditCardFactory;
import fr.isika.cda.model.factories.interfaces.FundRaisingFactory;

public class CreditCardFactoryImpl implements CreditCardFactory {
    private static CreditCardFactoryImpl instance = null;

    private CreditCardFactoryImpl(){}
    public static synchronized CreditCardFactoryImpl getInstance(){
        if (instance==null){
            instance = new CreditCardFactoryImpl();
        }
        return instance;
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }
    @Override
    public CreditCard getCreditCard(){
        return new CreditCard();
    }
}

package fr.isika.cda.model.factories.implementation;

import fr.isika.cda.model.entities.Payment;
import fr.isika.cda.model.factories.interfaces.PaymentFactory;

public class PaymentFactoryImpl implements PaymentFactory {
    private static PaymentFactoryImpl instance = null;

    private PaymentFactoryImpl(){}
    public static synchronized PaymentFactoryImpl getInstance(){
        if (instance==null){
            instance = new PaymentFactoryImpl();
        }
        return instance;
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }

    @Override
    public Payment getPayment(){
        return new Payment();
    }
}

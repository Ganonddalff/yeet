package fr.isika.cda.model.factories.implementation;

import fr.isika.cda.model.entities.FundRaising;
import fr.isika.cda.model.factories.interfaces.FundRaisingFactory;

public class FundRaisingFactoryImpl implements FundRaisingFactory {
    private static FundRaisingFactoryImpl instance = null;

    private FundRaisingFactoryImpl(){}
    public static synchronized FundRaisingFactoryImpl getInstance(){
        if (instance==null){
            instance = new FundRaisingFactoryImpl();
        }
        return instance;
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }
    @Override
    public FundRaising getFundRaising(){
        FundRaising fundRaising = new FundRaising();
        fundRaising.setRaisedFunds(0D);
        return fundRaising;
    }
}

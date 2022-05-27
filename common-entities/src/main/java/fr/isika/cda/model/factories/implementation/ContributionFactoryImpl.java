package fr.isika.cda.model.factories.implementation;

import fr.isika.cda.model.entities.Contribution;
import fr.isika.cda.model.factories.interfaces.ContactFactory;
import fr.isika.cda.model.factories.interfaces.ContributionFactory;

public class ContributionFactoryImpl implements ContributionFactory {
    private static ContributionFactoryImpl instance = null;
    private ContributionFactoryImpl(){}
    public static synchronized ContributionFactoryImpl getInstance(){
        if (instance==null){
            instance = new ContributionFactoryImpl();
        }
        return instance;
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }


    @Override
    public Contribution getContribution() {
        return new Contribution();
    }
}

package fr.isika.cda.model.factories.implementation;

import fr.isika.cda.model.entities.Association;
import fr.isika.cda.model.factories.interfaces.AssociationFactory;

public class AssociationFactoryImpl implements AssociationFactory {
    private static AssociationFactoryImpl instance = null;

    private AssociationFactoryImpl(){}

    public static synchronized AssociationFactoryImpl getInstance() {
        if (instance ==	null) {
            instance = new AssociationFactoryImpl();
        }
        return instance;
    }

    @Override
    public Object clone() throws CloneNotSupportedException	{
        throw new CloneNotSupportedException();
    }

    @Override
    public Association getAssociation() {
        return new Association();
    }
}

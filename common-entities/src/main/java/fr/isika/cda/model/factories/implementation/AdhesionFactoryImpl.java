package fr.isika.cda.model.factories.implementation;

import fr.isika.cda.model.entities.Adhesion;
import fr.isika.cda.model.factories.interfaces.AdhesionFactory;

public class AdhesionFactoryImpl implements AdhesionFactory {
    private static AdhesionFactoryImpl instance = null;

    private AdhesionFactoryImpl(){}

    public static synchronized AdhesionFactoryImpl getInstance() {
        if (instance ==	null) {
            instance = new AdhesionFactoryImpl();
        }
        return instance;
    }

    @Override
    public Object clone() throws CloneNotSupportedException	{
        throw new CloneNotSupportedException();
    }

    @Override
    public Adhesion getAdhesion() {
        return new Adhesion();
    }
}

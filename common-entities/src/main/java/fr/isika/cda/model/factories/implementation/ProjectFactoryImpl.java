package fr.isika.cda.model.factories.implementation;

import fr.isika.cda.model.entities.Project;
import fr.isika.cda.model.factories.interfaces.ProjectFactory;

public class ProjectFactoryImpl implements ProjectFactory {

    private static ProjectFactoryImpl instance = null;
    private ProjectFactoryImpl(){}
    public static synchronized ProjectFactoryImpl getInstance(){
        if (instance == null){
            instance = new ProjectFactoryImpl();
        }
        return instance;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }

    @Override
    public Project getProject() {
        return new Project();
    }
}

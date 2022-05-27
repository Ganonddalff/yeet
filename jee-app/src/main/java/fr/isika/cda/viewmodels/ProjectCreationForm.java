package fr.isika.cda.viewmodels;

import fr.isika.cda.model.entities.Project;
import fr.isika.cda.model.enumeration.ProjectType;
import fr.isika.cda.model.factories.implementation.ProjectFactoryImpl;

import javax.inject.Inject;
import java.util.Date;

public class ProjectCreationForm {
    private Project project;

    public ProjectCreationForm(){
        this.project= ProjectFactoryImpl.getInstance().getProject();
    }



    public Project getProject(){
        return project;
    }

    public void setProject(Project project){
        this.project=project;
    }
}

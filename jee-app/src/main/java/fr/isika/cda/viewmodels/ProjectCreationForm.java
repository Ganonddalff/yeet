package fr.isika.cda.viewmodels;

import fr.isika.cda.model.entities.Project;
import fr.isika.cda.model.factories.implementation.ProjectFactoryImpl;

public class ProjectCreationForm {
    private Project project;

    public ProjectCreationForm(){
        super();
        this.project= ProjectFactoryImpl.getInstance().getProjet();
    }

    public Project getProject(){
        return project;
    }

    public void setProject(Project project){
        this.project=project;
    }
}

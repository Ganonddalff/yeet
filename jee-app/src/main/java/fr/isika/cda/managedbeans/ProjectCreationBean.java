package fr.isika.cda.managedbeans;


import fr.isika.cda.services.ProjectCreationService;
import fr.isika.cda.viewmodels.ProjectCreationForm;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class ProjectCreationBean implements Serializable {
    private ProjectCreationForm projectCreationForm;

    @Inject
    private ProjectCreationService projectCreationService;
    public ProjectCreationBean(){
        this.projectCreationForm=new ProjectCreationForm();
    }
    public void create(){
        projectCreationService.createProject(this.projectCreationForm);
    }

    public ProjectCreationForm getProjectCreationForm() {
        return projectCreationForm;
    }

    public void setProjectCreationForm(ProjectCreationForm projectCreationForm) {
        this.projectCreationForm = projectCreationForm;
    }

    public ProjectCreationService getProjectCreationService() {
        return projectCreationService;
    }

    public void setProjectCreationService(ProjectCreationService projectCreationService) {
        this.projectCreationService = projectCreationService;
    }
}

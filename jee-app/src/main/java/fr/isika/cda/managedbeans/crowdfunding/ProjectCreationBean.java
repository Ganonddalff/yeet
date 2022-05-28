package fr.isika.cda.managedbeans.crowdfunding;
import fr.isika.cda.services.ProjectService;
import fr.isika.cda.viewmodels.form.crowdfunding.ProjectCreationForm;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class ProjectCreationBean implements Serializable {
    private ProjectCreationForm projectCreationForm;

    @Inject
    private ProjectService projectService;
    public ProjectCreationBean(){
        this.projectCreationForm = new ProjectCreationForm();
    }
    public void create(){
        projectService.createProject(this.projectCreationForm);
    }

    public ProjectCreationForm getProjectCreationForm() {
        return projectCreationForm;
    }

    public void setProjectCreationForm(ProjectCreationForm projectCreationForm) {
        this.projectCreationForm = projectCreationForm;
    }

    public ProjectService getProjectCreationService() {
        return projectService;
    }

    public void setProjectCreationService(ProjectService projectService) {
        this.projectService = projectService;
    }
}

package fr.isika.cda.viewmodels.form.crowdfunding;

import fr.isika.cda.model.entities.Project;
import fr.isika.cda.services.ProjectService;


public class ProjectManagementForm {

    private Project project;

    public ProjectManagementForm(Project project) {
        this.project=project;
    }



    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}

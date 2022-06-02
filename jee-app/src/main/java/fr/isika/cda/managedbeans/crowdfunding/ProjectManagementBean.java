package fr.isika.cda.managedbeans.crowdfunding;

import fr.isika.cda.model.entities.Project;
import fr.isika.cda.repositories.ProjectRepository;
import fr.isika.cda.services.ProjectService;
import fr.isika.cda.viewmodels.form.crowdfunding.ProjectManagementForm;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class ProjectManagementBean {
    @Inject
    private ProjectService projectService;

    private Long id;

    private ProjectManagementForm projectManagementForm;

    private Project project;

    public void init(){

        this.project= this.projectService.findById(id).get();
        this.projectManagementForm = new ProjectManagementForm(this.project);
    }

    public ProjectManagementBean(){}

    public void updateProject(){
        setProject(this.projectManagementForm.getProject());
        this.projectService.updateProject(this.project);
    }

    public String deleteProject(){
        setProject(this.projectManagementForm.getProject());
        this.projectService.deleteProject(this.project);
        return "/index.xhtml";
    }

    public ProjectManagementForm getProjectManagementForm() {
        return projectManagementForm;
    }

    public void setProjectManagementForm(ProjectManagementForm projectManagementForm) {
        this.projectManagementForm = projectManagementForm;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }
}

package fr.isika.cda.managedbeans.crowdfunding;

import fr.isika.cda.model.entities.Project;
import fr.isika.cda.services.ProjectService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class ProjectProfileBean {
    Long id;
    private Project project;
    @Inject
    private ProjectService projectService;
    public ProjectProfileBean(){}
    public void init(){
        this.project = projectService.findById(this.id).get();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}

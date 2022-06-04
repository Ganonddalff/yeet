package fr.isika.cda.managedbeans.crowdfunding;

import fr.isika.cda.model.entities.Project;
import fr.isika.cda.services.ProjectService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@ManagedBean
@ViewScoped
public class ProjectProfileBean {
    Long id;
    private Project project;
    @Inject
    private ProjectService projectService;

    public Boolean isProjectOwner(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return project.getAssociation().getId().equals((Long) session.getAttribute("idAssociation"));
    }
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

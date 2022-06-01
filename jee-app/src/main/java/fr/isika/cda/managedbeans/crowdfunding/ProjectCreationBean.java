package fr.isika.cda.managedbeans.crowdfunding;
import fr.isika.cda.services.AssociationService;
import fr.isika.cda.services.ProjectService;
import fr.isika.cda.viewmodels.form.crowdfunding.ProjectCreationForm;

import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class ProjectCreationBean implements Serializable {
    private ProjectCreationForm projectCreationForm;
    @Inject
    private AssociationService associationService;

    @Inject
    private ProjectService projectService;
    public ProjectCreationBean(){
        this.projectCreationForm = new ProjectCreationForm();
    }

    public String create(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        this.projectCreationForm.getProject().setAssociation(associationService.findById((Long) session.getAttribute("idAssociation")).get());
        projectService.createProject(this.projectCreationForm);
        return "/crowdfunding/CrowdfundingManagement?faces-redirect=true";
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

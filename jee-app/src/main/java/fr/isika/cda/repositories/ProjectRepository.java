package fr.isika.cda.repositories;

import fr.isika.cda.model.entities.FundRaising;
import fr.isika.cda.model.entities.Project;
import fr.isika.cda.viewmodels.ProjectCreationForm;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

@Stateless
public class ProjectRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public ProjectRepository(){}


    public Project createProject(ProjectCreationForm form){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Long associationId = (Long) session.getAttribute("id");
        FundRaising fr = form.getFundRaising();
        Project project = form.getProject();
        project.setFundRaising(fr);
        project.setAssociationId(associationId);

     //   entityManager.persist(fr);
        entityManager.persist(project);
        entityManager.flush();
        entityManager.clear();
        return form.getProject();
    }
}

package fr.isika.cda.repositories;

import fr.isika.cda.model.entities.FundRaising;
import fr.isika.cda.model.entities.Project;
import fr.isika.cda.viewmodels.form.crowdfunding.ProjectCreationForm;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    public Project updateProject(Project project){
        return this.entityManager.merge(project);
    }
    public Project getProjectById(Long id){
        return this.entityManager.find(Project.class,id);
    }

    public List<Project> findAll() {
        String query = "SELECT project FROM Project";
        return this.entityManager.createQuery("SELECT project FROM Project project", Project.class).getResultList();
    }
    public void deleteProject(Project project){
        this.entityManager.remove(project);
        this.entityManager.flush();
        this.entityManager.clear();
    }
}

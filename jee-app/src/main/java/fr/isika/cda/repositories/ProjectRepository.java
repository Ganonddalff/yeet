package fr.isika.cda.repositories;

import fr.isika.cda.model.entities.FundRaising;
import fr.isika.cda.model.entities.Project;
import fr.isika.cda.viewmodels.ProjectCreationForm;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProjectRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public ProjectRepository(){}

    public Project createProject(ProjectCreationForm form){
        FundRaising fr = form.getFundRaising();
        Project project = form.getProject();
        project.setFundRaising(fr);

     //   entityManager.persist(fr);
        entityManager.persist(project);
        entityManager.flush();
        entityManager.clear();
        return form.getProject();
    }
}

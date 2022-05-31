package fr.isika.cda.repositories;

import fr.isika.cda.model.entities.Project;
import fr.isika.cda.services.ProjectService;
import fr.isika.cda.viewmodels.form.crowdfunding.ContributionForm;
import fr.isika.cda.viewmodels.form.crowdfunding.ProjectCreationForm;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class ProjectRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public ProjectRepository(){}
    public Project createProject(ProjectCreationForm form){
        Project project = form.getProject();
        entityManager.persist(project);
        entityManager.flush();
        entityManager.clear();
        return form.getProject();
    }

    public Project updateProject(Project project){
        return this.entityManager.merge(project);
    }

    public Project contributeProject(ContributionForm contributionForm){
        Project project = contributionForm.getProject();
        return this.updateProject(project);
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

    public Optional<Project> findById(Long id) {
        try {
            Project project = this.entityManager
                    .createQuery("select project from Project project where project.id = :id", Project.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return Optional.ofNullable(project);
        } catch (NoResultException e){
            return Optional.empty();
        }
    }
}

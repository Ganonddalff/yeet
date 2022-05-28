package fr.isika.cda.services;

import fr.isika.cda.model.entities.Project;
import fr.isika.cda.repositories.ProjectRepository;
import fr.isika.cda.viewmodels.form.crowdfunding.ProjectCreationForm;

import javax.inject.Inject;
import java.util.List;

public class ProjectService {
    @Inject
    private ProjectRepository projectRepository;

    public ProjectService() {}
    public Project createProject(ProjectCreationForm projectCreationForm){
        return projectRepository.createProject(projectCreationForm);
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }
}

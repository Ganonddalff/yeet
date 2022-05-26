package fr.isika.cda.services;

import fr.isika.cda.model.entities.Project;
import fr.isika.cda.repositories.ProjectRepository;
import fr.isika.cda.viewmodels.ProjectCreationForm;

import javax.inject.Inject;

public class ProjectCreationService {
    @Inject
    private ProjectRepository projectRepository;

    public ProjectCreationService() {}
    public Project createProject(ProjectCreationForm projectCreationForm){
        return projectRepository.createProject(projectCreationForm);
    }
}

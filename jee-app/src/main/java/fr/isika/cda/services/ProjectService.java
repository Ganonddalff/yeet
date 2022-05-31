package fr.isika.cda.services;

import fr.isika.cda.model.entities.Association;
import fr.isika.cda.model.entities.FundRaising;
import fr.isika.cda.model.entities.Project;
import fr.isika.cda.repositories.ProjectRepository;
import fr.isika.cda.viewmodels.form.crowdfunding.ContributionForm;
import fr.isika.cda.viewmodels.form.crowdfunding.ProjectCreationForm;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Stateless
public class ProjectService {
    @Inject
    private ProjectRepository projectRepository;


    public ProjectService() {}
    public Project createProject(ProjectCreationForm projectCreationForm){
        FundRaising fr = projectCreationForm.getFundRaising();
        fr.setRaisedFunds(0D);
        Project project = projectCreationForm.getProject();
        project.setFundRaising(fr);
        return projectRepository.createProject(projectCreationForm);
    }

    public Project contributeProject(ContributionForm contributionForm){
        FundRaising fr = contributionForm.getProject().getFundRaising();
        fr.setRaisedFunds(fr.getRaisedFunds()+contributionForm.getContribution().getContributionAmount());
        return projectRepository.contributeProject(contributionForm);
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }
}

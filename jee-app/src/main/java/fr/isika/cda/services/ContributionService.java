package fr.isika.cda.services;

import fr.isika.cda.model.entities.Contribution;
import fr.isika.cda.model.entities.Project;
import fr.isika.cda.repositories.ContributionRepository;
import fr.isika.cda.viewmodels.form.crowdfunding.ContributionForm;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
@Stateless
public class ContributionService {
    @Inject
    private ContributionRepository contributionRepository;
    @Inject
    private ProjectService projectService;

    public ContributionService(){}
    public Contribution createContribution(ContributionForm contributionForm){
        Contribution contribution = contributionForm.getContribution();
        contribution.setDateContribution(Calendar.getInstance().getTime());
        contribution.setFundRaising(contributionForm.getFundRaising());
        projectService.contributeProject(contributionForm);
        return contributionRepository.createContribution(contributionForm);
    }

    public Contribution findById(Long id){
        return contributionRepository.findById(id).get();
    }
}

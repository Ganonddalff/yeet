package fr.isika.cda.services;

import fr.isika.cda.model.entities.Contribution;
import fr.isika.cda.repositories.ContributionRepository;
import fr.isika.cda.viewmodels.ContributionForm;

import javax.inject.Inject;

public class ContributionService {
    @Inject
    private ContributionRepository contributionRepository;

    public ContributionService(){}
    public Contribution createContribution(ContributionForm contributionForm){
        return contributionRepository.createContribution(contributionForm);
    }
}

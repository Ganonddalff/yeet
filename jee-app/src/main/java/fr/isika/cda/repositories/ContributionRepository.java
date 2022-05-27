package fr.isika.cda.repositories;

import fr.isika.cda.model.entities.Contribution;
import fr.isika.cda.model.entities.FundRaising;
import fr.isika.cda.model.entities.Project;
import fr.isika.cda.viewmodels.form.crowdfunding.ContributionForm;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ContributionRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public ContributionRepository(){}
    public Contribution createContribution(ContributionForm form){
        FundRaising fr = form.getFundRaising();
        Project project = form.getProject();
        Contribution contribution = form.getContribution();
        fr.setRaisedFunds(fr.getRaisedFunds()+contribution.getContributionAmount());
        entityManager.persist(contribution);
        entityManager.flush();
        entityManager.clear();
        return  form.getContribution();

    }
}

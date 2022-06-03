package fr.isika.cda.repositories;

import fr.isika.cda.model.entities.Contribution;
import fr.isika.cda.model.entities.FundRaising;
import fr.isika.cda.model.entities.Project;
import fr.isika.cda.viewmodels.form.crowdfunding.ContributionForm;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Stateless
public class ContributionRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public ContributionRepository(){}
    public Contribution createContribution(ContributionForm form){
        Contribution contribution = form.getContribution();
        entityManager.persist(contribution);
        FundRaising fr = form.getFundRaising();
        fr.addContribution(contribution);
        entityManager.merge(fr);
        entityManager.flush();
        /*entityManager.clear();*/
        return  contribution;

    }

    public Optional<Contribution> findById(Long id) {
        try {
            Contribution contribution = this.entityManager
                    .createQuery("select contribution from Contribution contribution where contribution.id = :id", Contribution.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return Optional.ofNullable(contribution);
        } catch (NoResultException e){
            return Optional.empty();
        }
    }
}

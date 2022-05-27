package fr.isika.cda.repositories;

import fr.isika.cda.model.entities.Account;
import fr.isika.cda.model.entities.Association;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class AssociationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public AssociationRepository(){

    }

    public Optional<Association> findById(Long id){
        try {
            Association association = this.entityManager
                    .createQuery("select a from Association a where a.id = :id", Association.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return Optional.ofNullable(association);
        } catch (NoResultException ex) {}
        return Optional.empty();
    }

    public List<Association> findAll(){
        return this.entityManager
                .createQuery("SELECT asso FROM Association asso", Association.class)
                .getResultList();
    }

    public Association update(Association association) {
        return this.entityManager.merge(association);
    }
}

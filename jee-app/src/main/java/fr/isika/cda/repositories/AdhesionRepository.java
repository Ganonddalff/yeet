package fr.isika.cda.repositories;

import fr.isika.cda.model.entities.Adhesion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Stateless
public class AdhesionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public AdhesionRepository(){}

    public Adhesion create(Adhesion adhesion) {
        entityManager.persist(adhesion);
        entityManager.flush();
        entityManager.clear();

        return adhesion;
    }

    public Optional<Adhesion> findById(Long adhesionId) {
        try {
            Adhesion adhesion = this.entityManager
                    .createQuery("select a from Adhesion a where a.id = :id", Adhesion.class)
                    .setParameter("id", adhesionId)
                    .getSingleResult();
            return Optional.ofNullable(adhesion);
        } catch (NoResultException ex) {}
        return Optional.empty();
    }
}
